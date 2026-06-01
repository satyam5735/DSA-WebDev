package SigmaBatchDSA.LiveSessions.Session15;

import java.util.*;

public class GrayCodeGenerator {

    // Recursive method to generate Gray Code sequence
    public static List<String> generateGrayCode(int n) {
        if (n == 0) {
            return Arrays.asList("0");
        }
        if (n == 1) {
            return Arrays.asList("0", "1");
        }

        // Get Gray code for n-1 bits
        List<String> prevGray = generateGrayCode(n - 1);
        List<String> result = new ArrayList<>();

        // Prefix '0' to the original sequence
        for (String code : prevGray) {
            result.add("0" + code);
        }

        // Prefix '1' to the reversed original sequence
        for (int i = prevGray.size() - 1; i >= 0; i--) {
            result.add("1" + prevGray.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 3; // Number of bits
        List<String> grayCodes = generateGrayCode(n);

        System.out.println("Gray Code sequence for " + n + " bits:");
        for (String code : grayCodes) {
            System.out.println(code);
        }
    }
}
