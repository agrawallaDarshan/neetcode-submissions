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
    public TreeNode invertTree(TreeNode root) {
        invertTreeInPlace(root);
        return root;
    }

    public void invertTreeInPlace(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        invertTreeInPlace(root.left);
        invertTreeInPlace(root.right);

        TreeNode leftTreeNode = root.left;
        root.left = root.right;
        root.right = leftTreeNode;
    }
}
