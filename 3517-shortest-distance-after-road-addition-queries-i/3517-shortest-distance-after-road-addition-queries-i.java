class Solution {
    List<int[]>[] graph;
    public void makeGraph(int n) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            graph[i].add(new int[]{i + 1, 1});
        }
    }
    public int bfs(int start, int end, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(new int[]{start, 0});
        visited[start] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[0];
            int dist = node[1];
            if (u == end) {
                return dist;
            }
            for (int[] edge : graph[u]) {
                int v = edge[0];
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new int[]{v, dist + edge[1]});
                }
            }
        }

        return -1;
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        makeGraph(n);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            graph[u].add(new int[]{v, 1});
            ans[i] = bfs(0, n - 1, n);
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution();
 * int[] param_1 = obj.shortestDistanceAfterQueries(n, queries);
*/