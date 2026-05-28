package SigmaBatch.ClassProblems.BasicSortingAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class InbuiltSort {
    public static void main(String[] args) {
        // Sorting the array in ascending order
        int arr1[] = {5, 4, 1, 3, 2};
        Arrays.sort(arr1); // Sort the entire array
        System.out.println("Ascending Order: " + Arrays.toString(arr1));

        // Sorting part of the array in descending order
        Integer arr2[] = {5, 4, 1, 3, 2}; // Use Integer instead of int
        Arrays.sort(arr2, 0, 3, Collections.reverseOrder()); // Sort first three elements in descending order
        System.out.println("Descending Order (Partial): " + Arrays.toString(arr2));
    }
}
