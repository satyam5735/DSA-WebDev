package SigmaBatchDSA.AssignProblems.VariablesAndDataTypes;

import java.util.Scanner;

public class average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int average = (a+b+c)/2;
        System.out.println(average);
    }
}
