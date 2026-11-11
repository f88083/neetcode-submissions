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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Integer> res = new ArrayList();
        
        if (root == null) return res;

        q.offer(root); 
        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                TreeNode cur = q.poll();

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

                // Add the right most node of each layer
                if (size == 1) {
                    res.add(cur.val);
                }
                --size;
            }
        }

        return res;
    }
}
