class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null || root.right == null) return root.val == 1 ? true : false;
        if(root.val == 3) { // if the root value is 3 i.e. is add
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            return left && right;
        } else if(root.val == 2){ // if the root value is 2 i.e. is or
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            return left || right;
        }
        return root.val == 1 ? true : false; 
    }
}
