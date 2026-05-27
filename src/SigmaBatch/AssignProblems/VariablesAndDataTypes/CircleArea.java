package SigmaBatch.AssignProblems.VariablesAndDataTypes;

import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double area = Math.PI * Math.pow(n, 2);
        System.out.println("The area of circle is : " + area);
    }
}
