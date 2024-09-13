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
    public int sumEvenGrandparent(TreeNode root) {
        HashMap<TreeNode , TreeNode> grandChildToGrandParentMap = new HashMap<>();
        dfs(root , null , null , grandChildToGrandParentMap);
        int sum = solve(root , grandChildToGrandParentMap);
        return sum;
    }
    int solve(TreeNode root , HashMap<TreeNode , TreeNode> map){
        if(root == null) return 0;
        int sum = 0;
        TreeNode grandParent = map.get(root);
        if(grandParent != null && grandParent.val % 2 == 0){ 
            sum += root.val;
        }
        int left = solve(root.left , map);
        int right = solve(root.right , map);
        return left + right + sum;
    }
    void dfs(TreeNode root , TreeNode parent , TreeNode grandParent , HashMap<TreeNode , TreeNode> map) {
        if(root == null) return;
        map.put(root , grandParent);
        dfs(root.left , root , parent , map);
        dfs(root.right , root , parent , map);
    }
}