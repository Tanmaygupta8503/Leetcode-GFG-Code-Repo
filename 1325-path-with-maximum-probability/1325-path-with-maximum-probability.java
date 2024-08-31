class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Object[]>> graph = buildGraph(n, edges, succProb);
        return dijkstra(graph, start, end);
    }

    private List<List<Object[]>> buildGraph(int n, int[][] edges, double[] succProb) {
        List<List<Object[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Integer u = edge[0];
            Integer v = edge[1];
            Double prob = succProb[i];
            graph.get(u).add(new Object []{v, prob});
            graph.get(v).add(new Object []{u, prob});
        }
        return graph;
    }
    private double dijkstra(List<List<Object[]>> graph, int start, int end) {
        int n = graph.size();
        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start] = 1.0;
        PriorityQueue<Object[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double)b[1], (double)a[1]));
        pq.offer(new Object[]{start, 1.0});
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            int node = (int)curr[0];
            double prob = (double)curr[1];
            if (node == end) return prob;
            if (prob < maxProb[node]) continue;
            for (var neighbor : graph.get(node)) {
                int nextNode = (int)neighbor[0];
                double nextProb = prob * (double)neighbor[1];
                if (nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = nextProb;
                    pq.offer(new Object[]{nextNode, nextProb});
                }
            }
        }
        return 0.0;
    }
}