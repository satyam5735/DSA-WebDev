package SigmaBatch.ClassProblems.Heaps;

import java.util.ArrayList;

public class DeleteinHeap {
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
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }
        public int remove() {
            int data = arr.get(0);

            //step1: swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));

            //step2: delete last
            arr.remove(arr.size() - 1);

            //step3: heapify
            heapify(0);
            return data;
        }
        public boolean isEmpty() {
            return arr.size() == 0;
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

        System.out.println("Removed: " + heap.remove());
        heap.printHeap();
        System.out.println("New Min: " + heap.peek());
    }
}