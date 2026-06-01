package SigmaBatchDSA.ClassProblems.Heaps;

import java.util.ArrayList;

public class InsertinHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // Add at last index
            arr.add(data);
            int x = arr.size() - 1; // Child index
            int par = (x - 1) / 2;  // Parent index

            // Bubble up
            while (x > 0 && arr.get(x) < arr.get(par)) {
                // Swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // Move up the tree
                x = par;
                par = (x - 1) / 2;
            }
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
        heap.printHeap(); // Output should show min-heap structure in array form
    }
}