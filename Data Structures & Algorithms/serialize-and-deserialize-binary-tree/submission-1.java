/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

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

    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        sb.append(root.val + ",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public void inorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        inorder(root.left, sb);
        sb.append(root.val + ",");
        inorder(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        if (sb.length() == 0)
            return "";
        sb.setCharAt(sb.length() - 1, '-');
        inorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0)
            return null;
        String[] traversal = data.split("-");
        String[] preorder = traversal[0].split(",");
        String[] inorder = traversal[1].split(",");
        int[] preorderInt = new int[preorder.length];
        int[] inorderInt = new int[preorder.length];
        for (int i = 0; i < preorder.length; i++) {
            preorderInt[i] = Integer.parseInt(preorder[i]);
            inorderInt[i] = Integer.parseInt(inorder[i]);
        }
        return buildTree(preorderInt, inorderInt);
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));