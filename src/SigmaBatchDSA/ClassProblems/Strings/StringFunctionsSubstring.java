package SigmaBatchDSA.ClassProblems.Strings;

public class StringFunctionsSubstring {
    public static String substring(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        //Substring
        String str = "DogsAreBarking";
        System.out.println(str.substring(0,4));
        System.out.println(substring(str, 0, 4));
    }
}
