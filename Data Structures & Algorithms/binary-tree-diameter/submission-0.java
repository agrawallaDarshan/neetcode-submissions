/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPath(TreeNode root, int[] result) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftMaxPath = maxPath(root.left, result);
        int rightMaxPath = maxPath(root.right, result);
        result[0] = Math.max(result[0], leftMaxPath + rightMaxPath);
        return 1 + Math.max(leftMaxPath, rightMaxPath);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        maxPath(root, result);
        return result[0];
    }
}
