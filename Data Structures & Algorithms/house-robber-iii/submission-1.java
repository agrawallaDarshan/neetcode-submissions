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
    public int solution(TreeNode root, boolean canRob, HashMap<TreeNode, Integer[]> map) {
        if (root == null)
            return 0;
        if (map.containsKey(root)) {
            Integer[] values = map.get(root);
            if (canRob && values[0] != null)
                return values[0];
            if (!canRob && values[1] != null)
                return values[1];
        }
        Integer[] values = new Integer[2];
        map.put(root, values);
        if (canRob) {
            return values[0] = Math.max(
                    root.val + solution(root.left, false, map) + solution(root.right, false, map),
                    solution(root.left, true, map) + solution(root.right, true, map));
        } else {
            return values[1] = solution(root.left, true, map) + solution(root.right, true, map);
        }
    }

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer[]> map = new HashMap<>();
        return solution(root, true, map);
    }
}