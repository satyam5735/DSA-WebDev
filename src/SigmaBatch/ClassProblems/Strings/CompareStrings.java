package SigmaBatch.ClassProblems.Strings;

public class CompareStrings {
    public static void main(String[] args) {
        String fruits[] = {"apple" , "mango" , "orange"};

        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareTo(fruits[i]) < 0) { //.compareTo - compares lexicographically(dictionary order)
                largest = fruits[i];
            }
        }
        System.out.println(largest);
    }
}
