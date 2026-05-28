package NKSir.RecursionAndBacktracking;

public class AllStringgsOfNBit {

    // Helper function to print the current combination
    private static void printArray(char[] arr) {
        System.out.println(new String(arr));
    }

    // The recursive function
    // n = total bits required, index = current position we are filling
    public static void generateBits(int n, char[] arr, int index) {
        // BASE CASE: If the current index equals n, it means the array is full
        if (index == n) {
            printArray(arr);
            return;
        }

        // Choice 1: Put '0' at the current position and move to the next index
        arr[index] = '0';
        generateBits(n, arr, index + 1);

        // Choice 2: Put '1' at the current position and move to the next index
        arr[index] = '1';
        generateBits(n, arr, index + 1);
    }

    public static void main(String[] args) {
        int n = 3; // Change this to generate strings of different lengths
        char[] arr = new char[n]; // Workspace array to hold the characters

        // Start from index 0
        generateBits(n, arr, 0);
    }
}