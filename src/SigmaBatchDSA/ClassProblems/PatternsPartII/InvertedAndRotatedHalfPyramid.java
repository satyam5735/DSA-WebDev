package SigmaBatchDSA.ClassProblems.PatternsPartII;

public class InvertedAndRotatedHalfPyramid {
    public static void inverted_rotated_half_Pyramid(int n) {
        //outer
        for (int i = 1; i <= n; i++) {
            //spaces
            for (int j = 1; j <= n-i ; j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        inverted_rotated_half_Pyramid(4);
    }
}
