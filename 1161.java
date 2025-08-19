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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<Long> arr = new ArrayList<>();
        while(!q.isEmpty()){
            int len = q.size();
            long sum =0;
            for(int i =0;i<len;i++){
                TreeNode cur = q.poll();
                sum+=cur.val;
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            arr.add(sum);
        }
        int ans =-1;
        long max = Long.MIN_VALUE;
        for(int i =0;i<arr.size();i++){
            long cur = arr.get(i);
            if(cur> max){
                max= cur;
                ans=i+1;
            }
        }
        return ans;
    }
}
