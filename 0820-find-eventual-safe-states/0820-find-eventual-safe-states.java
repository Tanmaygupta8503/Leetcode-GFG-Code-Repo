class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < graph.length ; i ++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < graph.length ; i ++) {
            for(int j : graph[i]) {
                adj.get(j).add(i);
            }
        }
        var ans = topoSort(adj);
        Collections.sort(ans);
        return ans;
    }
    List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        int indegree[] = new int[v];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < v ; i ++) {
            for(int neigh : adj.get(i)){
                indegree[neigh] ++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < v ; i ++) {
            if(indegree[i] == 0) q.add(i);
        } 
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int neigh : adj.get(node)) {
                indegree[neigh] --;
                if(indegree[neigh] == 0) q.add(neigh);
            }
        }
        return ans;
    }
}