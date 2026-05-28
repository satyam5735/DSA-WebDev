package SigmaBatch.ClassProblems.RecursionPart1;

public class DecOrder {
    public static void printDecOrder(int n) {
        if (n==1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDecOrder(n-1);
    }
    public static void main(String[] args) {
        int n = 10;
        printDecOrder(n);
    }
}
