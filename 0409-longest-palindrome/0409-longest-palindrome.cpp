class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char , int> map;
        for(auto c : s){
            map[c] ++;
        }
        int oddCount = 0;
        int ans = s.size();
        for (auto& entry : map) {
            if (entry.second % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount == 0) {
            return ans;
        }
        return ans - (oddCount - 1);
    }
};