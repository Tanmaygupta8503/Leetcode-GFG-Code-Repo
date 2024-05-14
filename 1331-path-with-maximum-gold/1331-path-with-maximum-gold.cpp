class Solution {
public:
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    int getMaximumGold(vector<vector<int>>& grid) {
        int maxi = 0;
        int n = grid.size();
        int m = grid[0].size();
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                vector<vector<int>> vis(n, vector<int>(m, 0));
                if(grid[i][j] != 0){
                    maxi = max(maxi , dfs(grid , i , j , vis)); 
                }
            }
        }
        return maxi;
    }

    int dfs(vector<vector<int>> &grid , int i , int j , vector<vector<int>> &vis) {
        int n = grid.size();
        int m = grid[0].size();
        if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] == 1 || grid[i][j] == 0) {
            return 0;
        }
        vis[i][j] = 1;
        int sum = 0 , maxi = 0;
        for(int k = 0 ; k < 4 ; k ++) {
            if(grid[i][j] != 0)
                maxi = max(maxi , grid[i][j] + dfs(grid, i + dx[k] , j + dy[k] , vis));
        }
        vis[i][j] = 0;
        return maxi;
    }
};
