package SigmaBatch.ClassProblems.Heaps;

import java.util.ArrayList;

public class MinimumValueGet {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (x > 0 && arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            return arr.get(0); // Minimum element
        }

        public void printHeap() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.add(5);
        heap.add(3);
        heap.add(8);
        heap.add(1);

        heap.printHeap(); // Should show: [1, 3, 8, 5]
        System.out.println("Min value: " + heap.peek());
    }
}