class Solution {
public:
    int n;
    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    int maximumSafenessFactor(vector<vector<int>>& grid) {
        n = grid.size();
        // Step 1: Pre-calculate the distance of the nearest thief for each cell
        vector<vector<int>> distNearestThief(n, vector<int>(n, -1));

        queue<pair<int, int>> q;
        vector<vector<bool>> vis(n, vector<bool>(n, false));

        // Push all the cells in queue where the thief is present
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.push({i, j});
                    vis[i][j] = true;
                }
            }
        }

        // Multisource BFS
        int level = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr_i = q.front().first;
                int curr_j = q.front().second;
                q.pop();
                distNearestThief[curr_i][curr_j] = level;
                for (int k = 0; k < 4; k++) {
                    int new_i = curr_i + dx[k];
                    int new_j = curr_j + dy[k];
                    if (new_i < 0 || new_j < 0 || new_i >= n || new_j >= n || vis[new_i][new_j]) {
                        continue;
                    }
                    q.push({new_i, new_j});
                    vis[new_i][new_j] = true;
                }
            }
            level++;
        }

        // Apply binary search on safeness factor
        int l = 0;
        int r = 400; // 400 is chosen as an upper bound; 
        int result = 0;
        while (l <= r) {
            int mid_sf = l + (r - l) / 2;
            if (check(distNearestThief, mid_sf)) {
                result = mid_sf;
                l = mid_sf + 1;
            } else {
                r = mid_sf - 1;
            }
        }
        return result;
    }

    bool check(vector<vector<int>>& distNearestThief, int mid_sf) {
        if (distNearestThief[0][0] < mid_sf) return false;
        
        queue<pair<int, int>> q;
        vector<vector<bool>> vis(n, vector<bool>(n, false));
        // Start from (0, 0) and try to reach (n-1, n-1)
        q.push({0, 0});
        vis[0][0] = true;
        while (!q.empty()) {
            int curr_i = q.front().first;
            int curr_j = q.front().second;
            q.pop();
            if (curr_i == n - 1 && curr_j == n - 1) return true;
            for (int k = 0; k < 4; k++) {
                int new_i = curr_i + dx[k];
                int new_j = curr_j + dy[k];
                if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n && !vis[new_i][new_j]) {
                    if (distNearestThief[new_i][new_j] < mid_sf) {
                        continue; // Reject the cell
                    }
                    q.push({new_i, new_j});
                    vis[new_i][new_j] = true;
                }
            }
        }
        return false;
    }
};

