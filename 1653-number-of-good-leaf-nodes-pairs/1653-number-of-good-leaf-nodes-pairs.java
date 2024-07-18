class Solution {
    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leafNodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodes.add(root);
        }
        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }
        makeGraph(root.left, root, adj, leafNodes);
        makeGraph(root.right, root, adj, leafNodes);
    }
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        makeGraph(root, null, adj, leafNodes);
        int count = 0; 
        for (TreeNode leaf : leafNodes) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.add(leaf);
            visited.add(leaf);
            for (int level = 0; level <= distance; level++) { 
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode curr = queue.poll();
                    if (curr != leaf && leafNodes.contains(curr)) {
                        count++;
                    }
                    for (TreeNode neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }
        return count / 2;
    }
}