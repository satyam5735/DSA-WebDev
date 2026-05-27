package SigmaBatch.ClassProblems.ArrayLists;


import java.util.ArrayList;

public class Intro {
    public static void main(String[] args) {
        //Java Collection Framework
        //ClassName objectName = new ClassName();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();


        //Add Operation
        list.add(1);//TC: O(1)
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        //Get Operation
        int element = list.get(2);
        System.out.println(element);

        //Remove Element
        list.remove(2);
        System.out.println(list);

        //Set Operation
        list.set(2, 10);
        System.out.println(list);

        //Contains Element
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        list.add(1,9);
        System.out.println(list);
    }
}
