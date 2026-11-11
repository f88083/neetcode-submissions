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
    // val -> index
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) return null;

        inorderMap = new HashMap();

        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preorderIndex, int low, int high) {
        if (preorderIndex > preorder.length - 1 || low > high) return null;
        
        // Get the root val
        int currentVal = preorder[preorderIndex];

        // father index in inorder
        int mid = inorderMap.get(currentVal);

        TreeNode father = new TreeNode(currentVal);
        father.left = build(preorder, preorderIndex + 1, low, mid - 1);
        father.right = build(preorder, preorderIndex + (mid - low + 1), mid + 1, high);
        return father;
    }
}
