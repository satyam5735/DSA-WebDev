package SigmaBatchDSA.LiveSessions.Session14;

//Question: For a given integer array of size N. You have to find all the occurrences(indices) of a given element (key) and print them. Use a recursive function to solve this problem. Sample Input: arr[] = {3,2,4,5,6,2,7,2,2}, key = 2. Sample Output: 1 5 7 8

public class FindAllOccurrences {

    // Recursive function to find and print indices of key
    public static void findIndices(int[] arr, int index, int key) {
        // Base case: if we've reached the end of the array
        if (index == arr.length) {
            return;
        }

        // If the element at the current index matches the key, print it
        if (arr[index] == key) {
            System.out.print(index + " ");
        }

        // Recursive call to check the next index
        findIndices(arr, index + 1, key);
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;

        System.out.print("Indices of key " + key + ": ");
        findIndices(arr, 0, key);
    }
}
//What’s Happening Here:
//        - The method findIndices() recursively traverses the array.
//        - Every time the current element equals the key, its index is printed.
//        - It naturally prints them in order thanks to top-down recursion.
//        - The base case ensures that recursion ends once the entire array has been scanned.
