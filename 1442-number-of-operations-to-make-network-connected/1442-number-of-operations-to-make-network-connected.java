class Solution {
    class DSU{
        int parent[] , rank[];
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0 ; i < n ; i ++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x){
            if(x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public void union(int x , int y) {
            int x_parent = find(x);
            int y_parent = find(y);
            if(x_parent != y_parent) {
                if(rank[x_parent] < rank[y_parent]){
                    parent[x_parent] = y_parent;
                }
                else if(rank[x_parent] > rank[y_parent]){
                    parent[y_parent] = x_parent;
                }else{
                    parent[y_parent] = x_parent;
                    rank[x_parent] ++;
                }
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        DSU dsu = new DSU(n);
        for(int edge[] : connections) {
            int x = edge[0];
            int y = edge[1];
            int x_parent = dsu.find(x);
            int y_parent = dsu.find(y);
            if(x_parent != y_parent) {
                dsu.union(x , y);
                n --;
            }
        }
        return n - 1;
    }
}