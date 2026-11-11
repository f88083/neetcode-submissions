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
    int res, count;
    public int kthSmallest(TreeNode root, int k) {
        res = 0;
        count = 0;
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) return;

        dfs(node.left, k);
        ++count;
        if (count == k) {
            res = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
