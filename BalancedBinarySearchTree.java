package dsa_assignment_08;

import java.util.Arrays;

/**
 *
 * @author 1999k
 */
class Node {

    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

public class BalancedBinarySearchTree {

    static Node root;

    /* A function that constructs Balanced Binary Search Tree
     from a sorted array */
    Node sortedArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    int steps = 0;

    public Node search(Node root, int key) {
        steps = steps + 1;
        // Base Cases: root is null or key is present at root
        if (root == null || root.data == key) {
            return root;
        }

        // Key is greater than root's key
        if (root.data < key) {
            return search(root.right, key);
        }

        // Key is smaller than root's key
        return search(root.left, key);
    }

    public static void main(String[] args) {
        BalancedBinarySearchTree tree = new BalancedBinarySearchTree();
        int arr[] = new int[]{2, 3, 7, 4, 1, 5, 6};

        System.out.println("");
        System.out.println("Given Array : ");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j + " ");
        }

        Arrays.sort(arr);

        System.out.println("");
        System.out.println("");
        System.out.println("Sorted Array : ");
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            System.out.print(j + " ");
        }

        int n = arr.length;
        root = tree.sortedArrayToBST(arr, 0, n - 1);

        System.out.println("");
        System.out.println("");
        System.out.println("Preorder traversal of constructed BST");

        tree.preOrder(root);

        System.out.println("");

        tree.steps = 0;
        Node nd1 = tree.search(root, 1);
        System.out.println("");
        if (nd1 != null) {
            System.out.println("Searching for : 1 ; Found in " + tree.steps + " steps.");
        } else {
            System.out.println("Searching for : 1 ; Not found in " + tree.steps + " steps.");
        }

        tree.steps = 0;
        Node nd4 = tree.search(root, 4);
        System.out.println("");
        if (nd4 != null) {
            System.out.println("Searching for : 4 ; Found in " + tree.steps + " steps.");
        } else {
            System.out.println("Searching for : 4 ; Not found in " + tree.steps + " steps.");
        }

        tree.steps = 0;
        Node nd10 = tree.search(root, 10);
        System.out.println("");
        if (nd10 != null) {
            System.out.println("Searching for : 10 ; Found in " + tree.steps + " steps.");
        } else {
            System.out.println("Searching for : 10 ; Not found in " + tree.steps + " steps.");
        }

        System.out.println("");

    }

}
