package SigmaBatch.ClassProblems.Hashing;
import java.util.*;
public class HashSetB {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        System.out.println(set);
        System.out.println(set.size());

        if(set.contains(5)) {
            System.out.println("Set contains 5");
        }
        if(set.contains(6)) {
            System.out.println("Set contains 6");
        }

        set.remove(2);
        if(set.contains(2)) {
            System.out.println("Set contains 2");
        }
        set.clear();
        System.out.println(set);
        System.out.println(set.isEmpty());
    }
}
