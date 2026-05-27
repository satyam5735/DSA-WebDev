package DataScience.Lct6_16Series;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first_term = 0;
        int second_term = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(first_term + " ");
            int next_term = first_term + second_term;

            first_term = second_term;
            second_term = next_term;
        }
    }
}
