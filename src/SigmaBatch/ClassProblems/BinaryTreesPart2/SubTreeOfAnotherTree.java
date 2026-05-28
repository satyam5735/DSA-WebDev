package SigmaBatch.ClassProblems.BinaryTreesPart2;

public class SubTreeOfAnotherTree {

    // Definition of Node
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Check if two trees are identical
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    // Main logic to check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) return true;      // an empty tree is a subtree of any tree
        if (root == null) return false;

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Test the implementation
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));  // Expected output: true
    }
}