class Solution {
public:
    long long countSubstrings(string s, char c) {
        long long freq = 0;
        for(auto ch : s) {
            if(ch == c) freq ++;
        }
        return freq * (freq + 1) / 2L; 
    }
};