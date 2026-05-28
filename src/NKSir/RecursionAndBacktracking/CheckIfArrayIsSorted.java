public class CheckIfArrayIsSorted {

    // The exact recursive function from your image
    boolean arraySortedOrNot(int[] arr, int n) {
        // Base Case: An array of size 0 or 1 is always sorted
        if (n == 0 || n == 1) {
            return true;
        }

        // Check if the current last element is smaller than the previous element
        if (arr[n - 1] < arr[n - 2]) {
            return false;
        }

        // Recursive Call: Shrink the size by 1 to check the rest of the array
        return arraySortedOrNot(arr, n - 1);
    }
}