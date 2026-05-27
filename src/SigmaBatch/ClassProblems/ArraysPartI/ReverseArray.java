package SigmaBatch.ClassProblems.ArraysPartI;

public class ReverseArray {
    public static void reverseArray(int numbers[]) {
        int first = 0 , last = numbers.length - 1;
        while (first < last) {
            //swap
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }
    public static void main(String[] args) {
        int numbers[] = {1 , 3 , 5 , 7 , 9};

        reverseArray(numbers);
        //print
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
