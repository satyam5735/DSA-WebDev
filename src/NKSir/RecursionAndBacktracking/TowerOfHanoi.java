package NKSir.RecursionAndBacktracking;

public class TowerOfHanoi {

    // n = number of discs
    // src = source rod, dest = destination rod, aux = auxiliary (helper) rod
    public static void solveHanoi(int n, char src, char dest, char aux) {
        // 1. BASE CASE: If there is only 1 disc, just move it
        if (n == 1) {
            System.out.println("Move disc 1 from " + src + " to " + dest);
            return;
        }

        // 2. RECURSIVE CALL 1: Move top (n-1) discs from src to aux, using dest as helper
        solveHanoi(n - 1, src, aux, dest);

        // 3. THE MAIN MOVE: Move the remaining largest disc from src to dest
        System.out.println("Move disc " + n + " from " + src + " to " + dest);

        // 4. RECURSIVE CALL 2: Move the (n-1) discs from aux to dest, using src as helper
        solveHanoi(n - 1, aux, dest, src);
    }

    public static void main(String[] args) {
        int n = 3; // Let's try with 3 discs
        solveHanoi(n, 'A', 'C', 'B'); // A = Source, C = Destination, B = Helper
    }
}