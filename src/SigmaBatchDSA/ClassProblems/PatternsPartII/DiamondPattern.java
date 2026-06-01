package SigmaBatchDSA.ClassProblems.PatternsPartII;

public class DiamondPattern {
    public static void DiamondPattern(int n) {
         //1st half
        for (int i = 1; i <= n; i++) {
            //print spaces
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half
        for (int i = n-1; i >=1; i--) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <= (2*i)-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DiamondPattern(4);
    }
}
