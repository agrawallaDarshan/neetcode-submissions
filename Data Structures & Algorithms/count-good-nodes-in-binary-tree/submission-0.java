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
    public void solution(TreeNode root, int upperLimit, int[] result) {
        if (root == null)
            return;
        if (root.val >= upperLimit)
            result[0]++;
        int newUpperLimit = Math.max(upperLimit, root.val);
        solution(root.left, newUpperLimit, result);
        solution(root.right, newUpperLimit, result);
    }

    public int goodNodes(TreeNode root) {
        int[] result = new int[1];
        solution(root, root.val, result);
        return result[0];
    }
}
