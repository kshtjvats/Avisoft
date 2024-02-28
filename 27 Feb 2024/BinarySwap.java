import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TreeNode class representing each node in the Binary Search Tree (BST)
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Reference to the left child
    TreeNode right; // Reference to the right child

    // Constructor to initialize the TreeNode with a given value
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinarySwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of nodes in the BST
        System.out.print("Enter the number of nodes in the BST: ");
        int n = scanner.nextInt();

        // Prompt the user to enter the values of the nodes
        System.out.println("Enter the values of the nodes:");
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            root = insert(root, val); // Insert each node into the BST
        }

        // Find and print the swapped nodes
        List<Integer> result = recoverTree(root);
        System.out.println("Swapped nodes: " + result);
    }

    // Method to insert a node into the BST
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
    // Method to recover the BST by finding the swapped nodes
    public static List<Integer> recoverTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        // Morris Traversal to find the two misplaced nodes
        while (current != null) {
            if (current.left == null) {
                if (prev != null && prev.val > current.val) {
                    if (first == null) {
                        first = prev;
                        second = current;
                    } else {
                        second = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    if (prev != null && prev.val > current.val) {
                        if (first == null) {
                            first = prev;
                            second = current;
                        } else {
                            second = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        // Add the values of the swapped nodes to the result list
        if (first != null && second != null) {
            result.add(first.val);
            result.add(second.val);
        }
        return result;
    }
}
