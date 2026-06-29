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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        int height = 0;

        while(!queue.isEmpty()){
            int n  = queue.size();
            for(int i = 0; i<n; i++){
                TreeNode temp = queue.poll();
                if(temp!= null && temp.left != null){
                    queue.offer(temp.left);
                }if(temp!= null && temp.right != null){
                    queue.offer(temp.right);
                }
            }
            height++;
        }

        return height;
    }
}
