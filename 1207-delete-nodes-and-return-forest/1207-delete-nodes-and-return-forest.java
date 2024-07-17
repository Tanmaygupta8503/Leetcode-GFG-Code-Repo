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
    List<TreeNode> ans = new ArrayList<TreeNode>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        set.add(-1);
        for(int i : to_delete){
            set.add(i);
        }
        deleteNode(new TreeNode(-1,root,null) , set); 
        if(!set.contains(root.val)) ans.add(root);
        return ans;
    }
    void deleteNode(TreeNode root , Set<Integer> set){
        if(root == null) return ;
        deleteNode(root.left , set);
        deleteNode(root.right , set);
        if(root.left != null && set.contains(root.left.val)) {
            if(root.left.left != null)
                ans.add(root.left.left);
            if(root.left.right != null)
                ans.add(root.left.right);
            root.left = null;
        }
        if(root.right != null && set.contains(root.right.val)) {
            if(root.right.left != null)
                ans.add(root.right.left);
            if(root.right.right != null)
                ans.add(root.right.right);
            root.right = null;
        }
    }
}