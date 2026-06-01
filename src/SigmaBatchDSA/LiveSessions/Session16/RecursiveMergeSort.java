package SigmaBatchDSA.LiveSessions.Session16;

import java.util.Arrays;

public class RecursiveMergeSort {

    // Recursive Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        // Sort left and right halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merge sorted halves
        merge(arr, left, mid, right);
    }

    // Merge two sorted subarrays
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] a1 = {5, 2, 3, 1};
        int[] a2 = {9, 7, 6, 4};

        // Step 1: Merge arrays
        int[] combined = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, combined, 0, a1.length);
        System.arraycopy(a2, 0, combined, a1.length, a2.length);

        // Step 2: Sort using recursive merge sort
        mergeSort(combined, 0, combined.length - 1);

        // Step 3: Print result
        System.out.println("Sorted merged array: " + Arrays.toString(combined));
    }
}
