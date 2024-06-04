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
    TreeNode target = null;
    Map<TreeNode , TreeNode> map = new HashMap();
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        assignParent(root , null , start);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        q.add(target);
        set.add(target);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            time ++;
            for(int i = 0 ; i < size ; i ++){
                TreeNode node = q.poll();
                if(node.left != null && !set.contains(node.left)){
                    q.add(node.left);
                    set.add(node.left);
                }
                if(node.right != null && !set.contains(node.right)){
                    q.add(node.right);
                    set.add(node.right);
                }
                if(map.get(node) != null && !set.contains(map.get(node))){
                    q.add(map.get(node));
                    set.add(map.get(node));
                }
            }
        }
        return time-1;
    }
    private void assignParent(TreeNode root , TreeNode prev , int start){
        if(root == null) return;
        map.put(root , prev);
        if(start == root.val) target = root;
        assignParent(root.left , root , start);
        assignParent(root.right , root , start);
    }
}