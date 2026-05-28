package SigmaBatch.ClassProblems.Hashing;

import java.util.HashMap;
import java.util.Set;

public class Iteration {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);


        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String key : keys) {
            System.out.println(hm.get(key));
        }
    }
}
