package SigmaBatch.ClassProblems.Queues;

public class QueueB {
    static class Queue {
        int arr[];
        int size;
        int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        // Add
        public void add(int data) {
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            arr[++rear] = data; //rear = rear+1; arr[rear] = data;
        }

        // Remove
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            // Shift elements to the left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front; //front = arr[0];
        }

        // Peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}