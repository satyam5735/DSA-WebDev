package SigmaBatchDSA.LiveSessions.Session15;

public class PowerCalculator {

    // Simple recursive method: a^n = a * power(a, n - 1)
    public static int simplePower(int a, int n) { //TC: O(n)
        if (n == 0) {
            return 1;
        }
        return a * simplePower(a, n - 1);
    }

    // Optimized recursive method: exponentiation by squaring
    public static int optimizedPower(int a, int n) { //TC: O(log(n))
        if (n == 0) {
            return 1;
        }

        int halfPower = optimizedPower(a, n / 2);

        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return a * halfPower * halfPower;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int n = 10;

        System.out.println("Simple Recursive Power:");
        System.out.println(a + "^" + n + " = " + simplePower(a, n));

        System.out.println("\nOptimized Recursive Power (Exponentiation by Squaring):");
        System.out.println(a + "^" + n + " = " + optimizedPower(a, n));
    }
}