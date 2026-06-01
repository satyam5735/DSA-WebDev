package SigmaBatchDSA.ClassProblems.Strings;

public class StringFunctionsCompare {
    public static void main(String[] args) {
        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if (s1==(s2)) { // == checks memory addresses
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }

        if (s1.equals(s3)) { // .equals checks the characters
            System.out.println("s1 equals s3");
        } else {
            System.out.println("s1 not equals s3");
        }
    }
}
