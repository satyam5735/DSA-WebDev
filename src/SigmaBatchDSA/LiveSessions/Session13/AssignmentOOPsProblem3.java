package SigmaBatchDSA.LiveSessions.Session13;

/**
 * Notes on Method Overriding and Access Modifiers in Java
 *
 * Rules:
 * - You can override a method using the same or a more accessible modifier.
 * - You cannot override a method with a more restrictive modifier.
 * - For example:
 *   • private → Cannot be overridden (not inherited).
 *   • protected → Can be overridden with protected or public.
 *   • public → Must stay public when overridden.
 */

class Shape {
    protected void display() {
        System.out.println("Display-base");
    }
}

class Circle extends Shape {
    // ✅ Valid: protected (same as superclass)
    // ✅ Also valid: public (more accessible than protected)
    // ❌ Not valid: private (would cause compile-time error)
    public void display() {
        System.out.println("Display-derived");
    }
}

public class AssignmentOOPsProblem3 {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.display();  // Output: "Display-derived"
    }
}
