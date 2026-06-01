package DataSciencePepCoding.Lct35_74Patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i ; j--) {
                System.out.print("     ");
            }
            for (int k = i; k >= 1 ; k--) {
                System.out.print("*    ");
            }
            System.out.println();
        }
    }
}
