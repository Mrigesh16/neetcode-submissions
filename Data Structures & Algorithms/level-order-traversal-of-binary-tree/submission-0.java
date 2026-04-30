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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode tempNode = queue.poll();
                if(tempNode != null){
                    tempList.add(tempNode.val);
                    if(tempNode.left != null)
                        queue.add(tempNode.left);
                    if(tempNode.right != null)
                        queue.add(tempNode.right);
                }
            }
            list.add(tempList);
        }

        return list;
    }
}
