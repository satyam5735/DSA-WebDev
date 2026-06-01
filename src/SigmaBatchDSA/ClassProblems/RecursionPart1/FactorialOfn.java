package SigmaBatchDSA.ClassProblems.RecursionPart1;

public class FactorialOfn {
    public static int factorialOfn(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorialOfn(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(factorialOfn(5));
    }
}
