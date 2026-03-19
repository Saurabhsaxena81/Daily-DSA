public class Solution {

    static int maxSize;

    static int[] solve(Node root) {

        // Base case: [isBST (1 or 0), size, min, max]

        if (root == null) {

            return new int[] { 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE };

        }

        int[] left = solve(root.left);

        int[] right = solve(root.right);

        // Current node is BST if left and right are BSTs and root data is in range

        if (left[0] == 1 && right[0] == 1 && root.data > left[3] && root.data < right[2]) {

            int curSize = 1 + left[1] + right[1];

            maxSize = Math.max(maxSize, curSize);

            return new int[] {

                    1,

                    curSize,

                    Math.min(root.data, left[2]),

                    Math.max(root.data, right[3])

            };

        }

        // Not a BST

        return new int[] { 0, 0, 0, 0 };

    }

    static int largestBst(Node root) {

        maxSize = 0;

        solve(root);

        return maxSize;
    }
}