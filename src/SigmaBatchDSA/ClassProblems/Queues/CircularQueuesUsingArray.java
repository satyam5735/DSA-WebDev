package SigmaBatchDSA.ClassProblems.Queues;

public class CircularQueuesUsingArray {
    static class Queue {
        int arr[];
        int size;
        int rear;
        int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add element to the queue
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if (isEmpty()) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove element from the queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];

            if (rear == front) {
                // Queue had only one element
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        // Peek front element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove()); // prints 1
        q.add(4);
        System.out.println(q.remove()); // prints 2
        q.add(5);
        q.add(6); // wrapping around should happen here
        q.add(7); // should trigger "Queue is full"

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}