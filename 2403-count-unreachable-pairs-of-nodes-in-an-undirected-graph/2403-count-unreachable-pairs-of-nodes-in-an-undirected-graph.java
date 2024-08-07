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
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        Map<Long , Long> map = new HashMap<>();
        for(int i[] : edges) {
            dsu.union(i[0] , i[1]);
        }   
        for(int i = 0 ; i < n ; i ++) {
            long i_parent = (long)dsu.find(i);
            map.put(i_parent , map.getOrDefault(i_parent , 0L) + 1);
        }
        long sum = 0L;
        for(var entry : map.entrySet()){
            sum += (long)(entry.getValue() * (n - entry.getValue()));
        }
        return sum / 2L;
    }
}