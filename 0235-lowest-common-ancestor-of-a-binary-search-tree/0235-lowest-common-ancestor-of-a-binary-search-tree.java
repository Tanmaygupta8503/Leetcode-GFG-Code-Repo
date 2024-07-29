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
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode node1 = null , node2 = null;
        if(root.val > p.val && root.val > q.val)
            node1 = lowestCommonAncestor(root.left , p , q); 
        if(root.val <= p.val && root.val <= q.val)
            node2 = lowestCommonAncestor(root.right , p , q); 
        else{
            node1 = lowestCommonAncestor(root.left , p , q); 
            node2 = lowestCommonAncestor(root.right , p , q);
        }
        if(node1 != null && node2 != null) return root;
        if(node1 != null) return node1;
        return node2;
    }
}