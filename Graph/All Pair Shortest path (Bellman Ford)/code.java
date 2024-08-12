class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        
        // making graph
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>();
        for(int i = 0 ; i < V ; i ++) {
            graph.add(new ArrayList<>());
        }
        for(var edge : edges) {
            int x = edge.get(0);
            int y = edge.get(1);
            int wt = edge.get(2);
            graph.get(x).add(new ArrayList<>(Arrays.asList(y , wt)));
        }
        // System.out.println(graph);
        // initialization
        int dist[] = new int[V];
        Arrays.fill(dist , (int)(1e8));
        dist[S] = 0;
        // System.out.println(graph);
        // traverse in graph for V - 1 times
        for(int i = 0 ; i < V - 1; i ++) {
            for(int j = 0 ; j < V ; j ++) {
                for(var neigh : graph.get(j)) {
                    if(dist[j] != (int)(1e8) && dist[neigh.get(0)] > dist[j] + neigh.get(1)){
                        dist[neigh.get(0)] = dist[j] + neigh.get(1);
                    }
                }
            }
        }
        for(int j = 0 ; j < V ; j ++) {
            for(var neigh : graph.get(j)) {
                if(dist[j] != (int)(1e8) && dist[neigh.get(0)] > dist[j] + neigh.get(1)){
                    return new int[]{-1};
                }
            }
        }
        return dist;
    }
}
