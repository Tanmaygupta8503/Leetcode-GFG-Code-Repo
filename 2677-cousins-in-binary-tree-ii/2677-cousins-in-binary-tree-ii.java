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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null)    return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 0;
        TreeNode curr = null ; int currSum = 0;
        while(!q.isEmpty()){
            int total = 0;
            for (int i = q.size(); i > 0; i--) {
                curr = q.poll();
                total += (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);
                q.offer(curr);
            }
            for (int i = q.size(); i > 0; i--) {
                curr = q.poll();
                currSum = (curr.left != null ? curr.left.val : 0) + (curr.right != null ? curr.right.val : 0);
                if (curr.left != null) {
                    curr.left.val = total - currSum;
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    curr.right.val = total - currSum;
                    q.offer(curr.right);
                }
            }
        }
        return root;
    }
}