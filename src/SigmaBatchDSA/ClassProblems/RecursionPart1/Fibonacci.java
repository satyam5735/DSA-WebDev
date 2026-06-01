package SigmaBatchDSA.ClassProblems.RecursionPart1;

public class Fibonacci {
    public static long fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long fnm1 = fibonacci(n - 1);
        long fnm2 = fibonacci(n - 2);
        long fn = fnm1 + fnm2;
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
