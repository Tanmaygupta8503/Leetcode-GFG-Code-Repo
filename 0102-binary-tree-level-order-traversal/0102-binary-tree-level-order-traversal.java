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
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size -- > 0){
                TreeNode node = q.poll();
                if(node != null){
                    temp.add(node.val);
                    if(node.left != null) {
                        q.add(node.left);
                    }
                    if(node.right != null) {
                        q.add(node.right);
                    }
                }
            }
            if(temp.size() > 0)
                list.add(temp);
        }
        return list;
    }
}