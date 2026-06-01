package SigmaBatchDSA.LiveSessions.Session16;

public class SortArray { //LeetCode Problem: 912
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Recursive merge sort
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        // Sort left half
        mergeSort(nums, left, mid);

        // Sort right half
        mergeSort(nums, mid + 1, right);

        // Merge sorted halves
        merge(nums, left, mid, right);
    }

    // Merge two sorted subarrays
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Merge elements from both halves
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy back to original array
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
    
    public static void main(String[] args) {
        SortArray sa = new SortArray();
        int[] nums = {5, 2, 8, 6, 1};
        nums = sa.sortArray(nums);
        
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}