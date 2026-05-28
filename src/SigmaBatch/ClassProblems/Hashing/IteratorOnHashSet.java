package SigmaBatch.ClassProblems.Hashing;
import java.util.*;
public class IteratorOnHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("London");
        cities.add("New York");
        cities.add("Paris");
        cities.add("New York");

        //a.Using Iterator
//        Iterator iterator = cities.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        //b.Using advanced for loop
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
