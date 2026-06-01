package SigmaBatchDSA.ClassProblems.LinkedListPart1;

public class AddFirst {
    public static class Node {
        int data;
        Node next; // Fixed: No need to reference HeadAndTail.Node

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head; // Fixed type
    public static Node tail; // Fixed type

    public void addFirst(int data) {
        Node newNode = new Node(data); // Step 1 = create a Node

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head; // Step 2 = NewNode's next = head;
        head = newNode;      // Step 3 = head = newNode;
    }

    public static void main(String[] args) {
        AddFirst ll = new AddFirst(); // Fixed: Changed HeadAndTail to AddFirst
        ll.addFirst(1);
        ll.addFirst(2);
    }
}