package SigmaBatchDSA.ClassProblems.BinaryTreesPart2;

public class DiameterOfTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    /** Returns the height of the binary tree. */
    public static int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /** Returns the total number of nodes in the binary tree. */
    public static int count(Node root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
    public static int diameter(Node root) { //TC: O(n^2)
        if (root == null) return 0;

        int leftDiameter = diameter(root.left);
        int leftHeight = height(root.left);
        int rightDiameter = diameter(root.right);
        int rightHeight = height(root.right);
        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(Math.max(leftDiameter, rightDiameter) , selfDiameter);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));
    }
}