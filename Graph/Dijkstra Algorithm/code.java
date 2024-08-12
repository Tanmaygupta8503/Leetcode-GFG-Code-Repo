class Solution {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        // Write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(a[0] , b[0]));
        int res[] = new int[V];
        Arrays.fill(res , Integer.MAX_VALUE);
        res[S] = 0;
        pq.add(new int[]{0 , S});
        while(!pq.isEmpty()) {
            int node[] = pq.poll();
            if (node[0] > res[node[1]]) {
                continue;
            }
            for(var neigh : adj.get(node[1])){
                if(res[neigh.get(0)] > neigh.get(1) + node[0]){
                    res[neigh.get(0)] = neigh.get(1) + node[0];
                    pq.add(new int[]{res[neigh.get(0)] , neigh.get(0)});
                }
            }
        }
        return res;
    }
}
