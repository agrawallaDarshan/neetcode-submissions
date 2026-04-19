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
    public int solution(TreeNode root, int[] result) {
        if (root == null)
            return -1000001;
        if (root.left == null && root.right == null)
            return root.val;
        int leftSum = solution(root.left, result);
        int rightSum = solution(root.right, result);
        int maxPathSum = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
        result[0] = Math.max(result[0],
                Math.max(Math.max(root.val + leftSum + rightSum, maxPathSum), Math.max(leftSum, rightSum)));
        return maxPathSum;
    }

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null)
            return root.val;
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        int leftMaxPath = solution(root.left, result);
        int rightMaxPath = solution(root.right, result);
        if (root.val + leftMaxPath > result[0])
            result[0] = root.val + leftMaxPath;
        if (root.val + rightMaxPath > result[0])
            result[0] = root.val + rightMaxPath;
        if (root.val + leftMaxPath + rightMaxPath > result[0])
            result[0] = root.val + leftMaxPath + rightMaxPath;
        result[0] = Math.max(result[0], Math.max(root.val, Math.max(leftMaxPath, rightMaxPath)));
        return result[0];
    }
}