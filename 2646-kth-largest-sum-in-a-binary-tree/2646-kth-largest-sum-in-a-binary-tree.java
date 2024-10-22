class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelsum = new ArrayList<>();
        level(root,levelsum);
        if(levelsum.size()<k){
            return -1;
        }
        Collections.sort(levelsum);
        return levelsum.get(levelsum.size()-k);       
    }
    public void level(TreeNode root, List<Long> levelsum){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Queue<TreeNode> m = new LinkedList<>();
            long sum = 0;
            while(!q.isEmpty()){
                TreeNode temp = q.remove();
                if(temp!=null){
                    m.add(temp.left);
                    m.add(temp.right);
                    sum+=temp.val;
                }
            }
            if(m.size()>0){
                levelsum.add(sum);
            }
            q = m;
        }
    }
}