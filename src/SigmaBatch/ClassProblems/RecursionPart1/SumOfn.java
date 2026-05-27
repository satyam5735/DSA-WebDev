package SigmaBatch.ClassProblems.RecursionPart1;

public class SumOfn {
    public static int sumOfn(int n) {
        if (n == 1) {
            return 1;
        }
        int Snm1 = sumOfn(n - 1);
        int Sn = n + Snm1;
        return Sn;
    }
    public static void main(String[] args) {
        System.out.println(sumOfn(5));
    }
}
