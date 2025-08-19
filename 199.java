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
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        q.offer(root);
        while (!q.isEmpty()) {
            int len = q.size();
            TreeNode r = null;
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                r = cur;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null)  q.offer(cur.right);
            }
            if(r!=null) ans.add(r.val);
        }
        return ans;
    }
}
