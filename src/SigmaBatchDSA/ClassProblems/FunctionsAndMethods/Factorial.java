package SigmaBatchDSA.ClassProblems.FunctionsAndMethods;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        System.out.println("The factorial of " + n + " is " + factorial(n));
    }
}
