class DSU {
    private int[] parent;
    private int[] rank;
    private int components;

    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        components = n;
        for(int i = 1; i <= n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent)
            return;

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
        components--;
    }

    public boolean isSingle() {
        return components == 1;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (v1, v2) -> Integer.compare(v2[0], v1[0]));

        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int addedEdges = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {
                boolean add = false;

                if (alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    add = true;
                }

                if (bob.find(u) != bob.find(v)) {
                    bob.union(u, v);
                    add = true;
                }

                if (add)    addedEdges++;
                } else if (type == 2) {
                    if (bob.find(u) != bob.find(v)) {
                        bob.union(u, v);
                        addedEdges++;
                }
            } else {
                if (alice.find(u) != alice.find(v)) {
                    alice.union(u, v);
                    addedEdges++;
                }
            }
        }

        if (alice.isSingle() && bob.isSingle()) {
            return edges.length - addedEdges;
        }

        return -1;
    }
}
