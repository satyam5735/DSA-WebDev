package SigmaBatchDSA.LiveSessions.Session14;

public class FibonacciSeries {

    // Recursive method to find the nth Fibonacci number
    public static int fibonacci(int n) {
        // Base case 1: if n is 0, return 0
        if (n == 0) return 0;

        // Base case 2: if n is 1, return 1
        if (n == 1) return 1;

        // Recursive case: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int count = 10;  // How many terms you want to print
        System.out.println("Fibonacci Series up to " + count + " terms:");

        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
// Base case 1: If n == 0, return 0 — this represents the 0th Fibonacci number
// Base case 2: If n == 1, return 1 — this is the 1st Fibonacci number
// Recursive step: For n > 1, calculate fibonacci(n - 1) + fibonacci(n - 2)
// This approach builds the result by breaking the problem into smaller subProblems
// Each call to fibonacci spawns two more calls until reaching the base case
// The final result is assembled by summing up the smaller Fibonacci values