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
    public int findNodeIndex(int[] inorder, int target, int left, int right) {
        for (int i = left; i <= right; i++)
            if (inorder[i] == target)
                return i;
        return -1;
    }

    public int[] findRootNodeValue(int[] preorder, int[] inorder, int left, int right) {
        int[] result = new int[2];
        for (int i = 0; i < preorder.length; i++) {
            int nodeIndex = findNodeIndex(inorder, preorder[i], left, right);
            if (nodeIndex != -1) {
                result[0] = preorder[i]; // root node value
                result[1] = nodeIndex; // Index in inorder
                return result;
            }
        }
        // System.out.println(Arrays.toString(result));
        return result;
    }

    public TreeNode solution(int[] preorder, int[] inorder, int left, int right) {
        if (left == right)
            return new TreeNode(inorder[left]);
        else if (left > right || right < left)
            return null;
        int[] values = findRootNodeValue(preorder, inorder, left, right);
        TreeNode node = new TreeNode(values[0]);
        node.left = solution(preorder, inorder, left, values[1] - 1);
        node.right = solution(preorder, inorder, values[1] + 1, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solution(preorder, inorder, 0, preorder.length - 1);
    }
}

// bt(0, 3) -> (0, 0) -> (2, 3) -> (2, 1) ->