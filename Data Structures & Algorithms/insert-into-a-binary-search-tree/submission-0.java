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

    public void insertAllValues(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        insertAllValues(root.left, list);
        insertAllValues(root.right, list);
    }

    public TreeNode constructBST(List<Integer> values, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = constructBST(values, start, mid - 1);
        root.right = constructBST(values, mid + 1, end);
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        List<Integer> values = new ArrayList<>();
        insertAllValues(root, values);
        values.add(val);
        Collections.sort(values);
        return constructBST(values, 0, values.size() - 1);
    }
}