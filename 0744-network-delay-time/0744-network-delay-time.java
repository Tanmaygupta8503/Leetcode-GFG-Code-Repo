class Solution {
    private class Edge{
        int u , v , wt;
        Edge(int u , int v , int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    private int dijkstra(ArrayList<Edge> graph[] , int src , int n){
        int dist[] = new int [n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[1] - b[1]);
        pq.add(new int[]{src , 0});
        while(!pq.isEmpty()){
            int []curr_node = pq.poll();
            int u = curr_node[0];
            int u_dist = curr_node[1];
            for(Edge edge : graph[u]) {
                int v = edge.v;
                int weight = edge.wt;
                if(u_dist + weight < dist[v]){
                    dist[v] = u_dist + weight;
                    pq.add(new int[] {v , dist[v]});
                }
            }
        }
        int max = 0;
        for(int i : dist) {
            if(i == Integer.MAX_VALUE) return -1;
            max = Math.max(i , max);
        }
        return max;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0 ; i < n ; i ++) {
            graph[i] = new ArrayList<Edge>();
        }
        for(int edge[] : times) {
            int u = edge[0] - 1; // Source node
            int v = edge[1] - 1; // Destination node
            int wt = edge[2]; // Weight of the edge
            graph[u].add(new Edge(u, v, wt));
        }
        // for(var list : graph){
        //     for(Edge i : list)
        //         System.out.print(i.u + " " + i.v + " " + i.wt + " ");
        //     System.out.println();
        // }
        return dijkstra(graph, k - 1, n);
    }
}