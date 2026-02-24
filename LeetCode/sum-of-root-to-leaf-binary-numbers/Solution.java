/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, it contributes 0 to the sum
        if (node == null) {
            return 0;
        }

        // Shift the current sum left by 1 bit and add the current node's value
        // Equivalently: currentSum = currentSum * 2 + node.val;
        currentSum = (currentSum << 1) | node.val;

        // If it's a leaf node, return the calculated binary number for this path
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // If it's not a leaf, recursively calculate the sum of left and right subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}

/*
 * Time Complexity: O(N) Where N is the number of nodes in the tree. We visit
 * exactly every node once during the DFS traversal.
 * Space Complexity: O(H) Where H is the height of the tree. This space is used
 * by the recursion stack. In the worst-case scenario (a completely unbalanced,
 * straight-line tree), this would be O(N). In the best-case scenario (a
 * perfectly balanced tree), it would be O(logN).
 */