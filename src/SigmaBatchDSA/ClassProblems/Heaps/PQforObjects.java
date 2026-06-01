package SigmaBatchDSA.ClassProblems.Heaps;

import java.util.PriorityQueue;

public class PQforObjects {
    static class Student implements Comparable<Student> {//Function Overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2) {
            return rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();//Comparator - priority high for large numbers

        pq.add(new Student("Jack", 3));
        pq.add(new Student("Joy", 2));
        pq.add(new Student("Jaz", 1));
        pq.add(new Student("Jay", 4));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);//O(1)
            pq.remove();
        }
    }
}
