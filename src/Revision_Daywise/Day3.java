package Revision_Daywise;

import java.util.Arrays;

public class Day3 {

    //  DAY-3

    //2D-Arrays
    //Spiral Matrix



    // Diagonal Sum
//    public static int DiagonalSum(int [][] matrix) {
//        int sum = 0;
//        for (int i = 0; i < matrix.length; i++) { //Primary Diagonal
//            sum += matrix[i][i];
//
//            if (i != matrix.length - 1 - i) {
//                sum+= matrix[i][matrix.length-1-i];
//            }
//        }
//        return sum;
//    }
//    public static void main(String[] args) {
//        int matrix[][] = {{1,2,3},{3,4,5},{5,6,5}};
//        System.out.println(DiagonalSum(matrix));
//    }

    // Search in Sorted 2d matrix
    public static int[] StairCaseSearch(int [][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{-1,-1};
        }
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return new int[]{i,j};
            }else if(matrix[i][j] > target){
                j--;
            }else {
                i++;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int target = 6;
        System.out.println(Arrays.toString(StairCaseSearch(matrix, target)));
    }
}
