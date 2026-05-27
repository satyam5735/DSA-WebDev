package SigmaBatch.LiveSessions.Session19;

import java.util.*;

public class Leet2150FindAllLonelyNumbersInTheArray {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : freq.keySet()) {
            if (freq.get(num) == 1 && !freq.containsKey(num - 1) && !freq.containsKey(num + 1)) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leet2150FindAllLonelyNumbersInTheArray ln = new Leet2150FindAllLonelyNumbersInTheArray();
        int[] nums = {10, 6, 5, 8};
        System.out.println(ln.findLonely(nums)); // Output: [10, 8]
    }
}
