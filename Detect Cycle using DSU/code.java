class Solution
{
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
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        DSU dsu = new DSU(V);
        for(int u = 0 ; u < V ; u ++) {
            for(var v : adj.get(u)){
                if(u < v){
                    int x = dsu.find(u);
                    int y = dsu.find(v);
                    if(x == y) return 1;
                    dsu.union(x , y);
                }
            }
        }
        return 0;
    }
}
