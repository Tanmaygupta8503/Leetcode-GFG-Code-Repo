class Solution {
public:
    long long minimumSteps(string s) {
        int wb = 0;
        long long step = 0;
        for(char c : s) (c == '0') ? step += wb : wb ++;
        return step;
    }
};