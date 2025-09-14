/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val == p.val || root.val==q.val) return root;
        TreeNode lef = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(lef!=null && r !=null){
            return root;
        }else if(lef!=null){
            return lef;
        }
        else if(r!=null){
            return r;
        }
        else{
            return null;
        }
    }
}
