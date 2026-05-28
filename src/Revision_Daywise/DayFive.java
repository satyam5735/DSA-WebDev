package Revision_Daywise;

public class DayFive {

    // RECURSION Part 1

    // Decreasing number

//    public static void DecOrder(int n) {
//        if (n == 0) {
//            return;
//        }
//        System.out.print(n + " ");
//        DecOrder(n - 1);
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the number: ");
//        int n = in.nextInt();
//        DecOrder(n);
//    }


    // Factorial
//    public static int Factorial(int n) {
//        if (n < 0) {
//            return -1;
//        }
//        if (n == 0 || n == 1) {
//            return 1;
//        }
//        return n * Factorial(n - 1);
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Enter the number:" + " ");
//        int n = in.nextInt();
//        System.out.println("The factorial of " + n + " is " + Factorial(n));
//
//    }

    // Fibonacci
//    public static int Fibonacci(int n){
//        if(n == 0){
//            return 0;
//        }
//        if(n == 1){
//            return 1;
//        }
//        return Fibonacci(n-1) + Fibonacci(n-2);
//    }
//    public static void main(String[] args) {
//        int n = 6;
//        System.out.println("Fibonacci number: " + Fibonacci(n));
//    }


    // Check if Array is sorted or not
//    public static boolean SortedOrNot(int[] arr){
//        if(arr == null || arr.length == 0){
//            return true;
//        }
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] < arr[i - 1]) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        int[] arr = new int[5];
//        Scanner in = new Scanner(System.in);
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }
//        System.out.println(SortedOrNot(arr));
//    }


    // First Occurrence(UnSorted) : For Sorted Use - Binary Search Method
//    public static int Occurrence(int[] arr, int key){
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == key) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
//        int key = 5;
//        int index = Occurrence(arr, key);
//        System.out.println("Key is at index: " + index);
//    }

    // For Last Occurrence Reverse the for loop backwards from i = arr.length - 1 , i <= 0, i--


    // Print X to power n

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        int n = in.nextInt();
//
//        int z = (int) Math.pow(x,n);
//        System.out.println(z);
//    }


    // Recursion Part 2

    //
    public static void main(String[] args) {

    }

}