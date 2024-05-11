class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        vector<int> dist(V, INT_MAX);
        dist[S] = 0;
        pq.push({0, S});
        while(!pq.empty()) {
            vector<int> node = pq.top();
            pq.pop();
            int u = node[1]; // Current node
            int d = node[0]; // Distance to current node
            for (auto& neigh : adj[u]) {
                int v = neigh[0]; // Neighbour node
                int w = neigh[1]; // Weight of edge from u to v
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.push({dist[v], v});
                }
            }
        }
        return dist;
    }
};
