package SigmaBatchDSA.ClassProblems.PatternsPartII;

public class HollowRectangle {
    public static void hollowRectangle(int totRows, int totCols) {
        //outer loop
        for (int i = 1; i <= totRows; i++) {
            //inner loop
            for (int j = 1; j <= totCols; j++) {
                //cell - (i,j)
                if (i == 1 || j == 1 || i == totRows || j == totCols) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollowRectangle(4, 5);
    }
}
