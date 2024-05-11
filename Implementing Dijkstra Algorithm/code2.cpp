class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        set<pair<int, int>> st;
        vector<int> dist(V, INT_MAX);
        dist[S] = 0;
        st.insert({0, S});
        while (!st.empty()) {
            auto node = *(st.begin());
            int d = node.first; // Distance to current node
            int u = node.second; // Current node
            st.erase(node);
            for (auto& neigh : adj[u]) {
                int v = neigh[0]; // Neighbour node
                int w = neigh[1]; // Weight of edge from u to v
                if (d + w < dist[v]) {
                    // erase if existed
                    if (dist[v] != INT_MAX) {
                        st.erase({dist[v], v});
                    }
                    dist[v] = d + w;
                    st.insert({dist[v], v});
                }
            }
        }
        return dist;
    }
};
