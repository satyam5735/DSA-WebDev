package SigmaBatch.ClassProblems.PatternsPartII;

public class InvertedHalfPyramidWithNumbers {
    public static void invertedPyramidWithNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            //inner - numbers
            for ( int j = 1 ; j <= n - i + 1 ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        invertedPyramidWithNumbers(5);
    }
}
