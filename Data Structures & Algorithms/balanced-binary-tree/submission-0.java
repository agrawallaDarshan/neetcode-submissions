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
    public int treeHeight(TreeNode root, int[] result) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (result[0] < 2) {
            int leftTreeHeight = treeHeight(root.left, result);
            int rightTreeHeight = treeHeight(root.right, result);
            result[0] = Math.max(result[0], Math.abs(leftTreeHeight - rightTreeHeight));
            return 1 + Math.max(leftTreeHeight, rightTreeHeight);
        }
        return -1;
    }

    public boolean isBalanced(TreeNode root) {
        int[] result = new int[1];
        treeHeight(root, result);
        return result[0] < 2;
    }
}
