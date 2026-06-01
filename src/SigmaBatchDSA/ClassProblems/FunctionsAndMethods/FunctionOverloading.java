package SigmaBatchDSA.ClassProblems.FunctionsAndMethods;

public class FunctionOverloading {
    public static int sum(int a, int b) {
        return a + b;
    }
    //Using Parameters
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }
    //Using Data Types
    public static float sum(float a, float b) {
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println(sum(3,5));
        System.out.println(sum(5,2,1));
        System.out.println(sum(3.5f,3.5f));
    }
}
