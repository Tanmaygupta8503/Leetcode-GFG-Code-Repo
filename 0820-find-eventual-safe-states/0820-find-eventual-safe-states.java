class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revGraph = new ArrayList<>();
        int n = graph.length;
        for(int i = 0 ; i < n ; i ++){
            revGraph.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int i = 0 ; i < n ; i ++){
            for(int j : graph[i]){
                revGraph.get(j).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n; i ++){
            if(indegree[i] == 0){
                q.add(i);
                list.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(var neigh : revGraph.get(node)){
                indegree[neigh] --;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                    list.add(neigh);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}