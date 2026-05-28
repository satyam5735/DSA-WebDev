package SigmaBatch.LiveSessions.Session3;

import java.util.Scanner;

public class NtoPowM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the exponent (m): ");
        int m = scanner.nextInt();
        scanner.close();

        long result = (long) Math.pow(n, m);
        System.out.println(n + " raised to the power " + m + " is: " + result);
    }
}