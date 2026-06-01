package SigmaBatchDSA.LiveSessions.Session15;


//🏰 Problem Statement: Tower of Hanoi
//You have:
//- 3 rods: Source (from), Auxiliary (aux), and Destination (to)
//- n disks of different sizes stacked on the source rod (largest at bottom)
//- Goal: Move all disks to the destination rod following these rules:
//- Only one disk can be moved at a time.
//- A disk can only be placed on top of a larger disk (or an empty rod).
//- You can use the auxiliary rod to help move disks.

//🔁 Recursive Strategy
//To move n disks from (from) to (to) using aux:
//- Move n-1 disks from (from) to (aux) using to
//- Move the nth (largest) disk from (from) to (to)
//- Move n-1 disks from (aux) to (to) using from

public class TowerProblem { //TowerOfHanoi

    // Recursive method to solve Tower of Hanoi
    public static void solveHanoi(int n, char from, char to, char aux) {
        if (n == 0) {
            return;
        }

        // Step 1: Move n-1 disks from 'from' to 'aux'
        solveHanoi(n - 1, from, aux, to);

        // Step 2: Move the nth disk from 'from' to 'to'
        System.out.println("Move disk " + n + " from " + from + " to " + to);

        // Step 3: Move n-1 disks from 'aux' to 'to'
        solveHanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) {
        int numDisks = 3;
        System.out.println("Tower of Hanoi solution for " + numDisks + " disks:");
        solveHanoi(numDisks, 'A', 'C', 'B'); // A = source, C = destination, B = auxiliary
    }
}
