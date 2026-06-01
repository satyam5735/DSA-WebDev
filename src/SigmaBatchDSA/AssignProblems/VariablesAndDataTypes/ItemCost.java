package SigmaBatchDSA.AssignProblems.VariablesAndDataTypes;

import java.util.Scanner;

public class ItemCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pencil cost");
        float a = sc.nextFloat();
        System.out.println("Enter the pen cost");
        float b = sc.nextFloat();
        System.out.println("Enter the eraser cost");
        float c = sc.nextFloat();
        System.out.println("The gst is : 18%");
        float total = (float)((a+b+c) +(0.18*(a+b+c)));
        System.out.println("The total cost is " + total);
    }
}
