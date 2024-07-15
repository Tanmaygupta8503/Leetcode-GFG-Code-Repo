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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer , TreeNode> map = new HashMap<>();
        for(int node[] : descriptions) {
            int parent = node[0];
            int child = node[1];
            map.put(child , new TreeNode(child));
        }
        TreeNode root = null;
        for(int node[] : descriptions) {
            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];
            if(map.get(parent) == null) {
                root = new TreeNode(parent);
                map.put(parent , root);
            }
        }
        for(int node[] : descriptions) {
            int parent = node[0];
            int child = node[1];
            int isLeft = node[2];
            if(isLeft == 1)
                map.get(parent).left = map.get(child);
            else 
                map.get(parent).right = map.get(child);
        }
        return root;
    }
}