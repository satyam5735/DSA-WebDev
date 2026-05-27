package SigmaBatch.ClassProblems.Hashing;
import java.util.*;
public class LinkedHashSetB {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bengaluru");

        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Mumbai");
        lhs.add("Delhi");
        lhs.add("Bengaluru");
        System.out.println(lhs);

        lhs.remove("Mumbai");
        System.out.println(lhs);
    }
}
