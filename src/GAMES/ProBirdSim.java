/*
 * =========================================================================================
 * PROJECT TITLE: Professional 3D Boids Flocking Simulation
 * * DESCRIPTION:
 * This application is a custom-built, software-rendered 3D particle simulation. It models
 * the complex emergent behavior of a flock of birds (boids) navigating 3D space. The
 * simulation features a cinematic chase camera, dynamic atmospheric depth (fog), flat-shaded
 * polygon lighting, and interactive mouse-tracking for the flock.
 * * CORE ALGORITHMS:
 * 1. Craig Reynolds' Boids Algorithm: Drives the flocking behavior using four steering forces:
 * - Separation: Prevents boids from colliding with local flock mates.
 * - Alignment: Matches the velocity and heading of nearby flock mates.
 * - Cohesion: Steers boids toward the average position of local flock mates.
 * - Attraction (New): Steers the flock toward a 3D coordinate mapped from the mouse pointer.
 * 2. 3D-to-2D Projection Pipeline: A custom software rasterizer that converts 3D world
 * coordinates into 2D screen space using a view matrix and perspective divide.
 * 3. Painter's Algorithm: Sorts rendered triangles by Z-depth to handle occlusion (drawing
 * back-to-front).
 * * LIBRARIES USED:
 * - Pure Java Standard Library (JDK 8+)
 * - javax.swing.* / java.awt.* : For window creation, UI threading, and 2D graphics context.
 * - java.awt.geom.Path2D : For drawing arbitrary polygon shapes (the boids).
 * - java.util.* : For standard data structures (Lists) and Random number generation.
 * - NO external 3D libraries (OpenGL, LWJGL, Java3D) were used. All 3D math is calculated
 * on the CPU from scratch.
 * =========================================================================================
 */

package GAMES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProBirdSim extends JPanel {

    // --- Configuration ---
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FLOCK_SIZE = 150;

    // --- State ---
    private final List<Boid> flock = new ArrayList<>();
    private final Camera camera = new Camera();
    private final Vector3 lightDir = new Vector3(0.5, -1, 0.8).normalize();

    // UI & Interaction
    private GradientPaint skyGradient;
    private int lastWidth = 0, lastHeight = 0;
    private Point mousePos = null;

    public ProBirdSim() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Initialize Flock
        for (int i = 0; i < FLOCK_SIZE; i++) {
            flock.add(new Boid());
        }

        // --- MOUSE TRACKER SETUP ---
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) { mousePos = e.getPoint(); }
            @Override
            public void mouseDragged(MouseEvent e) { mousePos = e.getPoint(); }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) { mousePos = null; } // Stop tracking when mouse leaves window
        });

        // Game Loop - ~60 FPS
        Timer timer = new Timer(16, e -> {
            updatePhysics();
            repaint();
        });
        timer.start();
    }

    private void updatePhysics() {
        Vector3 center = new Vector3(0, 0, 0);
        for (Boid b : flock) {
            center = center.add(b.position);
        }
        center = center.scale(1.0 / flock.size());

        // Map mouse 2D screen coordinates to a 3D world target roughly at the flock's Z-depth
        Vector3 mouseTarget3D = null;
        if (mousePos != null) {
            double mappedX = (mousePos.x - getWidth() / 2.0) * 1.5;
            double mappedY = -(mousePos.y - getHeight() / 2.0) * 1.5;
            mouseTarget3D = center.add(new Vector3(mappedX, mappedY, 0));
        }

        // Update all birds
        for (Boid b : flock) {
            b.update(flock, mouseTarget3D);
        }

        // Cinematic smooth camera follow
        Vector3 targetCamPos = center.add(new Vector3(0, 150, -400));
        camera.position = camera.position.lerp(targetCamPos, 0.03);
        camera.lookAt(center);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // 1. Draw Sky Gradient
        if (skyGradient == null || getWidth() != lastWidth || getHeight() != lastHeight) {
            lastWidth = getWidth();
            lastHeight = getHeight();
            skyGradient = new GradientPaint(0, 0, new Color(100, 180, 255), 0, lastHeight, new Color(220, 240, 255));
        }
        g2.setPaint(skyGradient);
        g2.fillRect(0, 0, getWidth(), getHeight());

        // 2. Rendering Pipeline
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        List<RenderableTriangle> renderList = new ArrayList<>();

        for (Boid b : flock) {
            List<Triangle> mesh = b.getGeometry();

            for (Triangle tri : mesh) {
                Vector3 v1 = transform(tri.v1, b);
                Vector3 v2 = transform(tri.v2, b);
                Vector3 v3 = transform(tri.v3, b);

                Vector3 normal = v2.subtract(v1).cross(v3.subtract(v1)).normalize();
                Vector3 camToTri = v1.subtract(camera.position);

                // Back-face Culling
                if (normal.dot(camToTri) >= 0) continue;

                // Lighting
                double lightIntensity = Math.max(0.3, normal.dot(lightDir.scale(-1)));

                Point p1 = project(v1);
                Point p2 = project(v2);
                Point p3 = project(v3);

                if (p1 != null && p2 != null && p3 != null) {
                    double zDepth = (v1.distance(camera.position) + v2.distance(camera.position) + v3.distance(camera.position)) / 3.0;

                    int baseR = tri.color.getRed(), baseG = tri.color.getGreen(), baseB = tri.color.getBlue();
                    int r = Math.min(255, Math.max(0, (int)(baseR * lightIntensity)));
                    int gr = Math.min(255, Math.max(0, (int)(baseG * lightIntensity)));
                    int bl = Math.min(255, Math.max(0, (int)(baseB * lightIntensity)));

                    // Atmospheric Fog
                    double fogFactor = Math.min(1.0, Math.max(0.0, (zDepth - 300) / 1000.0));
                    r = (int) (r * (1 - fogFactor) + 100 * fogFactor);
                    gr = (int) (gr * (1 - fogFactor) + 180 * fogFactor);
                    bl = (int) (bl * (1 - fogFactor) + 255 * fogFactor);

                    renderList.add(new RenderableTriangle(p1, p2, p3, new Color(r, gr, bl), zDepth));
                }
            }
        }

        // 3. Painter's Algorithm (Sort by Depth)
        renderList.sort((t1, t2) -> Double.compare(t2.depth, t1.depth));

        // 4. Rasterize to Screen
        for (RenderableTriangle rt : renderList) {
            Path2D path = new Path2D.Double();
            path.moveTo(rt.p1.x, rt.p1.y);
            path.lineTo(rt.p2.x, rt.p2.y);
            path.lineTo(rt.p3.x, rt.p3.y);
            path.closePath();

            g2.setColor(rt.color);
            g2.fill(path);

            g2.setColor(rt.color.darker());
            g2.draw(path);
        }
    }

    // --- Math Helpers ---
    private Vector3 transform(Vector3 v, Boid b) {
        Vector3 forward = b.velocity.normalize();
        Vector3 up = new Vector3(0, 1, 0);

        if (Math.abs(forward.dot(up)) > 0.99) up = new Vector3(1, 0, 0); // Gimbal lock fix

        Vector3 right = up.cross(forward).normalize();
        Vector3 realUp = forward.cross(right).normalize();

        double x = v.x * right.x + v.y * realUp.x + v.z * forward.x;
        double y = v.x * right.y + v.y * realUp.y + v.z * forward.y;
        double z = v.x * right.z + v.y * realUp.z + v.z * forward.z;

        return new Vector3(x + b.position.x, y + b.position.y, z + b.position.z);
    }

    private Point project(Vector3 v) {
        Vector3 rel = v.subtract(camera.position);

        Vector3 f = camera.target.subtract(camera.position).normalize();
        Vector3 u = new Vector3(0, 1, 0);
        if (Math.abs(f.dot(u)) > 0.99) u = new Vector3(1, 0, 0);

        Vector3 r = u.cross(f).normalize();
        Vector3 ru = f.cross(r).normalize();

        double x_cam = rel.dot(r);
        double y_cam = rel.dot(ru);
        double z_cam = rel.dot(f);

        if (z_cam <= 10) return null;

        double fov = 800;
        double x_screen = getWidth() / 2.0 + (x_cam * fov) / z_cam;
        double y_screen = getHeight() / 2.0 - (y_cam * fov) / z_cam;

        return new Point((int)x_screen, (int)y_screen);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Professional 3D Bird Sim");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ProBirdSim());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

// --- Data Structures ---

class Vector3 {
    final double x, y, z;
    Vector3(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
    Vector3 add(Vector3 v) { return new Vector3(x+v.x, y+v.y, z+v.z); }
    Vector3 subtract(Vector3 v) { return new Vector3(x-v.x, y-v.y, z-v.z); }
    Vector3 scale(double s) { return new Vector3(x*s, y*s, z*s); }
    double dot(Vector3 v) { return x*v.x + y*v.y + z*v.z; }
    Vector3 cross(Vector3 v) { return new Vector3(y*v.z - z*v.y, z*v.x - x*v.z, x*v.y - y*v.x); }
    double length() { return Math.sqrt(x*x + y*y + z*z); }
    Vector3 normalize() { double l = length(); return l==0 ? this : scale(1/l); }
    double distance(Vector3 v) { return Math.sqrt((x-v.x)*(x-v.x) + (y-v.y)*(y-v.y) + (z-v.z)*(z-v.z)); }
    Vector3 lerp(Vector3 v, double t) { return this.add(v.subtract(this).scale(t)); }
}

class Triangle {
    Vector3 v1, v2, v3;
    Color color;
    Triangle(Vector3 v1, Vector3 v2, Vector3 v3, Color c) { this.v1=v1; this.v2=v2; this.v3=v3; this.color=c; }
}

class RenderableTriangle {
    Point p1, p2, p3;
    Color color;
    double depth;

    RenderableTriangle(Point p1, Point p2, Point p3, Color c, double d) {
        this.p1 = p1; this.p2 = p2; this.p3 = p3; this.color = c; this.depth = d;
    }
}

class Camera {
    Vector3 position = new Vector3(0, 0, -500);
    Vector3 target = new Vector3(0, 0, 0);
    void lookAt(Vector3 t) { this.target = t; }
}

class Boid {
    Vector3 position;
    Vector3 velocity;
    double wingPhase;
    Color birdColor;

    static final double MAX_SPEED = 7.0;
    static final double MAX_FORCE = 0.25;
    static final Random rand = new Random();

    Boid() {
        position = new Vector3((rand.nextDouble()-0.5)*800, (rand.nextDouble()-0.5)*800, (rand.nextDouble()-0.5)*800);
        velocity = new Vector3(rand.nextDouble()-0.5, rand.nextDouble()-0.5, rand.nextDouble()-0.5).normalize().scale(MAX_SPEED);
        wingPhase = rand.nextDouble() * Math.PI * 2;

        int shade = 200 + rand.nextInt(55);
        int gb = 220 + rand.nextInt(35);
        birdColor = new Color(shade, gb, 255);
    }

    void update(List<Boid> flock, Vector3 mouseTarget3D) {
        Vector3 separation = new Vector3(0,0,0);
        Vector3 alignment = new Vector3(0,0,0);
        Vector3 cohesion = new Vector3(0,0,0);
        int count = 0;

        for (Boid other : flock) {
            if (other == this) continue;
            double d = position.distance(other.position);
            if (d > 0 && d < 70) {
                separation = separation.add(position.subtract(other.position).normalize().scale(1/d));
                alignment = alignment.add(other.velocity);
                cohesion = cohesion.add(other.position);
                count++;
            }
        }

        Vector3 force = new Vector3(0,0,0);

        // 1. Core Boid Forces
        if (count > 0) {
            separation = separation.scale(3.0);
            alignment = alignment.scale(1.0/count).normalize().scale(MAX_SPEED).subtract(velocity).scale(1.2);
            cohesion = cohesion.scale(1.0/count).subtract(position).normalize().scale(MAX_SPEED).subtract(velocity).scale(0.8);
            force = force.add(separation).add(alignment).add(cohesion);
        }

        // 2. Mouse Attraction Force (Seek)
        if (mouseTarget3D != null) {
            Vector3 attraction = mouseTarget3D.subtract(position).normalize().scale(MAX_SPEED).subtract(velocity).scale(1.5);
            force = force.add(attraction);
        } else {
            // Soft boundary sphere to keep them in view ONLY if mouse is not guiding them
            double distFromCenter = position.length();
            if (distFromCenter > 800) {
                force = force.add(position.normalize().scale(-MAX_SPEED * 0.05 * (distFromCenter - 800)/100));
            }
        }

        velocity = velocity.add(force);
        if (velocity.length() > MAX_SPEED) velocity = velocity.normalize().scale(MAX_SPEED);
        position = position.add(velocity);

        // Flap speed based on velocity
        wingPhase += 0.15 + (velocity.length() / MAX_SPEED) * 0.1;
    }

    List<Triangle> getGeometry() {
        List<Triangle> mesh = new ArrayList<>();
        double wingY = Math.sin(wingPhase) * 10;

        Vector3 nose = new Vector3(0, 0, 18);
        Vector3 tail = new Vector3(0, 0, -8);
        Vector3 leftWing = new Vector3(-18, wingY, -4);
        Vector3 rightWing = new Vector3(18, wingY, -4);
        Vector3 bodyBottom = new Vector3(0, -4, -4);

        mesh.add(new Triangle(nose, leftWing, tail, birdColor));
        mesh.add(new Triangle(nose, tail, rightWing, birdColor));
        mesh.add(new Triangle(nose, bodyBottom, leftWing, birdColor.darker()));
        mesh.add(new Triangle(nose, rightWing, bodyBottom, birdColor.darker()));
        mesh.add(new Triangle(tail, leftWing, bodyBottom, birdColor.darker()));
        mesh.add(new Triangle(tail, bodyBottom, rightWing, birdColor.darker()));

        return mesh;
    }
}