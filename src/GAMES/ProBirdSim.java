package GAMES;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProBirdSim extends JPanel {

    // --- Configuration ---
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FLOCK_SIZE = 100;

    // --- State ---
    private final List<Boid> flock = new ArrayList<>();
    private final Camera camera = new Camera();
    private final Vector3 lightDir = new Vector3(0.5, -1, 0.5).normalize(); // Sun direction

    public ProBirdSim() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Initialize Flock
        for (int i = 0; i < FLOCK_SIZE; i++) {
            flock.add(new Boid());
        }

        // Game Loop
        Timer timer = new Timer(16, e -> {
            updatePhysics();
            repaint();
        });
        timer.start();
    }

    private void updatePhysics() {
        // Calculate flock center for camera tracking
        Vector3 center = new Vector3(0, 0, 0);
        for (Boid b : flock) {
            b.update(flock);
            center = center.add(b.position);
        }
        center = center.scale(1.0 / flock.size());

        // Smooth camera follow
        Vector3 targetCamPos = center.add(new Vector3(0, 100, -300)); // Behind and above
        camera.position = camera.position.lerp(targetCamPos, 0.05);
        camera.lookAt(center);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // 1. Draw Sky Gradient
        GradientPaint sky = new GradientPaint(0, 0, new Color(135, 206, 250), 0, HEIGHT, new Color(255, 255, 255));
        g2.setPaint(sky);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // 2. Rendering Pipeline
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

        List<RenderableTriangle> renderList = new ArrayList<>();

        for (Boid b : flock) {
            // Create the bird mesh (Dynamic based on wing flap)
            List<Triangle> mesh = b.getGeometry();

            // Model -> World -> View Transform
            for (Triangle tri : mesh) {
                Vector3 v1 = transform(tri.v1, b);
                Vector3 v2 = transform(tri.v2, b);
                Vector3 v3 = transform(tri.v3, b);

                // Normal Calculation for Lighting & Culling
                Vector3 normal = v2.subtract(v1).cross(v3.subtract(v1)).normalize();

                // Back-face Culling: If normal points away from camera, don't draw
                Vector3 camToTri = v1.subtract(camera.position);
                if (normal.dot(camToTri) >= 0) continue;

                // Lighting Calculation (Flat Shading)
                double lightIntensity = Math.max(0.2, normal.dot(lightDir.scale(-1))); // Ambient + Diffuse

                // Project to Screen
                Point p1 = project(v1);
                Point p2 = project(v2);
                Point p3 = project(v3);

                if (p1 != null && p2 != null && p3 != null) {
                    // Depth sorting value (average Z)
                    double zDepth = (v1.distance(camera.position) + v2.distance(camera.position) + v3.distance(camera.position)) / 3.0;

                    // Color handling with simple "Fog"
                    int baseR = 255, baseG = 255, baseB = 255; // White birds
                    if (tri.color != null) { baseR = tri.color.getRed(); baseG = tri.color.getGreen(); baseB = tri.color.getBlue(); }

                    int r = (int)(baseR * lightIntensity);
                    int gr = (int)(baseG * lightIntensity);
                    int bl = (int)(baseB * lightIntensity);

                    // Clamp colors
                    r = Math.min(255, Math.max(0, r));
                    gr = Math.min(255, Math.max(0, gr));
                    bl = Math.min(255, Math.max(0, bl));

                    renderList.add(new RenderableTriangle(p1, p2, p3, new Color(r, gr, bl), zDepth));
                }
            }
        }

        // 3. Sort Triangles by Depth (Painter's Algorithm)
        renderList.sort((t1, t2) -> Double.compare(t2.depth, t1.depth));

        // 4. Rasterize
        for (RenderableTriangle rt : renderList) {
            Path2D path = new Path2D.Double();
            path.moveTo(rt.p1.x, rt.p1.y);
            path.lineTo(rt.p2.x, rt.p2.y);
            path.lineTo(rt.p3.x, rt.p3.y);
            path.closePath();

            g2.setColor(rt.color);
            g2.fill(path);

            // Subtle outline for definition
            g2.setColor(rt.color.darker());
            g2.draw(path);
        }
    }

    // --- Math Helpers ---
    private Vector3 transform(Vector3 v, Boid b) {
        // Rotate vector v by boid's orientation, then translate
        // Build LookAt Rotation Matrix
        Vector3 forward = b.velocity.normalize();
        Vector3 up = new Vector3(0, 1, 0);
        Vector3 right = up.cross(forward).normalize();
        Vector3 realUp = forward.cross(right).normalize();

        double x = v.x * right.x + v.y * realUp.x + v.z * forward.x;
        double y = v.x * right.y + v.y * realUp.y + v.z * forward.y;
        double z = v.x * right.z + v.y * realUp.z + v.z * forward.z;

        return new Vector3(x + b.position.x, y + b.position.y, z + b.position.z);
    }

    private Point project(Vector3 v) {
        // View Transform (World -> Camera Space)
        Vector3 rel = v.subtract(camera.position);

        // Rotate into Camera View (Simplified LookAt for fixed camera up)
        // For a true pro cam we'd use a full view matrix, but we'll cheat slightly for performance
        // by keeping the camera axes aligned or simple.
        // actually, let's just do raw perspective on the relative vector for the "Chase Cam" feel
        // assuming camera looks roughly -Z.

        // Manual View Matrix application
        Vector3 f = camera.target.subtract(camera.position).normalize();
        Vector3 u = new Vector3(0,1,0);
        Vector3 r = u.cross(f).normalize();
        Vector3 ru = f.cross(r).normalize();

        double x_cam = rel.dot(r);
        double y_cam = rel.dot(ru);
        double z_cam = rel.dot(f);

        if (z_cam <= 1) return null; // Behind camera or clipping plane

        double fov = 1000;
        double x_screen = WIDTH / 2.0 + (x_cam * fov) / z_cam;
        double y_screen = HEIGHT / 2.0 - (y_cam * fov) / z_cam; // Invert Y for screen coords

        return new Point((int)x_screen, (int)y_screen);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Professional 3D Bird Sim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ProBirdSim());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
    double distance(Vector3 v) { return Math.sqrt(Math.pow(x-v.x,2) + Math.pow(y-v.y,2) + Math.pow(z-v.z,2)); }
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

    // ERROR WAS HERE: "p3" was missing "Point" before it
    RenderableTriangle(Point p1, Point p2, Point p3, Color c, double d) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = c;
        this.depth = d;
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

    static final double MAX_SPEED = 6.0;
    static final double MAX_FORCE = 0.2;
    static final Random rand = new Random();

    Boid() {
        position = new Vector3((rand.nextDouble()-0.5)*500, (rand.nextDouble()-0.5)*500, (rand.nextDouble()-0.5)*500);
        velocity = new Vector3(rand.nextDouble()-0.5, rand.nextDouble()-0.5, rand.nextDouble()-0.5).normalize().scale(MAX_SPEED);
        wingPhase = rand.nextDouble() * Math.PI * 2;
    }

    void update(List<Boid> flock) {
        // Simple Flocking Rules
        Vector3 separation = new Vector3(0,0,0);
        Vector3 alignment = new Vector3(0,0,0);
        Vector3 cohesion = new Vector3(0,0,0);
        int count = 0;

        for (Boid other : flock) {
            double d = position.distance(other.position);
            if (d > 0 && d < 60) {
                separation = separation.add(position.subtract(other.position).normalize().scale(1/d));
                alignment = alignment.add(other.velocity);
                cohesion = cohesion.add(other.position);
                count++;
            }
        }

        Vector3 force = new Vector3(0,0,0);
        if (count > 0) {
            separation = separation.scale(2.5);
            alignment = alignment.scale(1.0/count).normalize().scale(MAX_SPEED).subtract(velocity).scale(1.0);
            cohesion = cohesion.scale(1.0/count).subtract(position).normalize().scale(MAX_SPEED).subtract(velocity).scale(1.0);
            force = force.add(separation).add(alignment).add(cohesion);
        }

        // Keep in bounds (soft return)
        if (position.length() > 600) {
            force = force.add(position.scale(-0.005));
        }

        // Apply
        velocity = velocity.add(force);
        if (velocity.length() > MAX_SPEED) velocity = velocity.normalize().scale(MAX_SPEED);
        position = position.add(velocity);

        wingPhase += 0.2;
    }

    List<Triangle> getGeometry() {
        List<Triangle> mesh = new ArrayList<>();
        double wingY = Math.sin(wingPhase) * 8;

        // Define local vertices for a "Paper Airplane" style bird
        Vector3 nose = new Vector3(0, 0, 15);
        Vector3 tail = new Vector3(0, 0, -10);
        Vector3 leftWing = new Vector3(-20, wingY, -5);
        Vector3 rightWing = new Vector3(20, wingY, -5);
        Vector3 bodyBottom = new Vector3(0, -3, -5); // Adds 3D volume

        Color bodyColor = Color.WHITE;

        // Top Faces
        mesh.add(new Triangle(nose, leftWing, tail, bodyColor));
        mesh.add(new Triangle(nose, tail, rightWing, bodyColor));

        // Bottom Faces (To give it volume)
        mesh.add(new Triangle(nose, bodyBottom, leftWing, bodyColor.darker()));
        mesh.add(new Triangle(nose, rightWing, bodyBottom, bodyColor.darker()));
        mesh.add(new Triangle(tail, leftWing, bodyBottom, bodyColor.darker()));
        mesh.add(new Triangle(tail, bodyBottom, rightWing, bodyColor.darker()));

        return mesh;
    }
}