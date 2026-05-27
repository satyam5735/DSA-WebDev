package SigmaBatch.ClassProblems.BitManipulation;

public class EvenOdd {
    public static void OddorEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0){
            //even number
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
    public static void main(String[] args) {
        OddorEven(3);
        OddorEven(11);
        OddorEven(14);
    }
}
