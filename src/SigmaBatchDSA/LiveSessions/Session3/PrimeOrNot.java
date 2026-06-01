package SigmaBatchDSA.LiveSessions.Session3;

import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (n): ");
        int n = scanner.nextInt();
        scanner.close();

        boolean isPrime = (n > 1);

        System.out.println("Factors of " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i > 1 && i < n) isPrime = false; // Found a non-trivial factor
            }
        }

        System.out.println();
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
