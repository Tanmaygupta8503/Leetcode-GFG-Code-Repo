class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        sort(position.begin() , position.end());
        int low = 1, high = ceil(position[position.size() - 1]/(m - 1.0));
        int ans = 0;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(placeBall(position , m , mid)) ans = mid , low = mid + 1;
            else high = mid - 1;
        }
        return ans;
    }
    bool placeBall(vector<int>& ballPos , int ball , int dist) {
        int start = ballPos[0] , ballCount = 1;
        for(int i = 1 ; i < ballPos.size() && ballCount < ball ; i ++)
            if((ballPos[i] - start) >= dist) ballCount ++ , start = ballPos[i];
        return ballCount == ball;
    }
};