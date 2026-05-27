package SigmaBatch.LiveSessions.Session13;

/**
 * AssignmentOOPsProblem4.java
 *
 * Demonstrates the order of execution in Java involving:
 * - Static blocks
 * - Instance initializer blocks
 * - Constructors
 * across an inheritance chain.
 */

abstract class Carr {
    static {
        System.out.print("1"); // Static block in Car — runs once when class loads
    }

    {
        System.out.print("3"); // Instance initializer — runs before constructor
    }

    public Carr(String name) {
        super();               // Implicit call to Object constructor
        System.out.print("2"); // Constructor logic
    }
}

public class AssignmentOOPsProblem4 extends Carr {
    {
        System.out.print("4"); // Instance initializer in subclass
    }

    public AssignmentOOPsProblem4() {
        super("blue");         // Triggers Car constructor
        System.out.print("5"); // Subclass constructor logic
    }

    public static void main(String[] args) {
        new AssignmentOOPsProblem4(); // Trigger instantiation
    }
}
//Summary:
//        - 1 — Static block of Car when loaded
//- 3 — Car’s instance block
//- 2 — Car’s constructor
//- 4 — Subclass’s instance block
//- 5 — Subclass’s constructor
//You can use this file as a go-to reference for constructor and initializer behavior.
