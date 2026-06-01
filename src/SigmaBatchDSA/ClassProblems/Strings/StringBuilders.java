package SigmaBatchDSA.ClassProblems.Strings;

public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }//abcde....z    TC:O(26)
        System.out.println(sb);
    }
}
