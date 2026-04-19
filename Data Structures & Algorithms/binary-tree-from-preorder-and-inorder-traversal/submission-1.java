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
    public int[] findRootNodeValue(int[] preorder, HashMap<Integer, Integer> inorderIndices, int left, int right) {
        int[] result = new int[2];
        for (int i = 0; i < preorder.length; i++) {
            int nodeIndex = inorderIndices.get(preorder[i]);
            if (nodeIndex >= left && nodeIndex <= right) {
                result[0] = preorder[i];
                result[1] = nodeIndex;
                return result;
            }
        }
        return result;
    }

    public TreeNode solution(int[] preorder, int[] inorder, HashMap<Integer, Integer> inorderIndices, int left,
            int right) {
        if (left == right)
            return new TreeNode(inorder[left]);
        else if (left > right || right < left)
            return null;
        int[] values = findRootNodeValue(preorder, inorderIndices, left, right);
        TreeNode node = new TreeNode(values[0]);
        node.left = solution(preorder, inorder, inorderIndices, left, values[1] - 1);
        node.right = solution(preorder, inorder, inorderIndices, values[1] + 1, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndices = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderIndices.put(inorder[i], i);
        return solution(preorder, inorder, inorderIndices, 0, preorder.length - 1);
    }
}
