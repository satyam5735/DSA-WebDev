package DataSciencePepCoding.Lct35_74Patterns;

import java.util.Scanner;
public class Pattern12 { //Fibonacci Sequence in the form of a right triangle
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();

        int a = 0, b = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + "\t");
                int next = a + b;
                a = b;
                b = next;
            }
            System.out.println(); // Move to the next row
        }
    }
}
