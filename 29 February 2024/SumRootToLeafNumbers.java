// TreeNode class representing a node in a binary tree
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Reference to the left child node
    TreeNode right; // Reference to the right child node

    // Constructor to initialize the node with a value
    TreeNode(int x) {
        val = x;
    }
}

// Class to calculate the sum of root-to-leaf numbers in a binary tree
public class SumRootToLeafNumbers {

    // Method to calculate the sum of root-to-leaf numbers
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0); // Call the depth-first search method starting from the root with initial sum 0
    }

    // Depth-first search method to recursively calculate the sum of root-to-leaf numbers
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0; // If the node is null, return 0
        }

        currentSum = currentSum * 10 + node.val; // Calculate the current sum considering the value of the current node

        // Check if it's a leaf node (i.e., both left and right children are null)
        if (node.left == null && node.right == null) {
            return currentSum; // Return the current sum if it's a leaf node
        }

        // Recursively calculate sum for left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

    // Main method to demonstrate the usage of the SumRootToLeafNumbers class
    public static void main(String[] args) {
        // Example usage:
        // Create a binary tree
        TreeNode root = new TreeNode(4); // Root node with value 4
        root.left = new TreeNode(9); // Left child of the root with value 9
        root.right = new TreeNode(0); // Right child of the root with value 0
        root.left.left = new TreeNode(5); // Left child of the left child with value 5
        root.left.right = new TreeNode(1); // Right child of the left child with value 1

        // Calculate the total sum of all root-to-leaf numbers
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers(); // Create an instance of SumRootToLeafNumbers class
        int totalSum = solution.sumNumbers(root) % 1003; // Calculate the sum and take modulo 1003
        System.out.println("Total sum of all root-to-leaf numbers: " + totalSum); // Print the total sum
    }
}
