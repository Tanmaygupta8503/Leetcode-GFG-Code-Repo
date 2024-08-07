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
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for(var equation : equations) {
            if(equation.charAt(1) == '='){
                dsu.union(equation.charAt(0) - 'a' , equation.charAt(3) - 'a');
            }
        }
        for(var equation : equations){
            if(equation.charAt(1) == '!') {
                int x = dsu.find(equation.charAt(0) - 'a');
                int y = dsu.find(equation.charAt(3) - 'a');
                if(x == y) return false;
            }
        }
        return true;
    }
}