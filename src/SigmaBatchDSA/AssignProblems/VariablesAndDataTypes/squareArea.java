package SigmaBatchDSA.AssignProblems.VariablesAndDataTypes;

import java.util.Scanner;

public class squareArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the side");
        int side = sc.nextInt();
        int area = side * side;
        System.out.println("The area is " + area);
    }
}
