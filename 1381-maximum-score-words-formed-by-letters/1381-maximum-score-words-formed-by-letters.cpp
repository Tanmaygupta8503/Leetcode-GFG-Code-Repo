class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& scor) {
        unordered_map<char,int> mp;
        for(auto &c : letters) {
            mp[c] ++;
        }
        unordered_map<string , int> score;
        for(auto str : words) {
            int sum = 0;
            for(auto c : str) {
                sum += scor[c-'a'];
            }
            score[str] = sum;
        }
        int i = 0;
        return solve(words , mp , score , i);
    }
    int solve(vector<string> &words , unordered_map<char , int> &mp ,
                                      unordered_map<string , int> &score , int i) {
        if(i >= words.size()) {
            return 0;
        }
        int op1 = 0, op2 = 0;
        if(canMake(words[i] , mp)){
            op2 = 0 + solve(words , mp , score, i + 1);
            for(auto c : words[i]) {
                mp[c] --;
            }
            op1 = score[words[i]] + solve(words, mp , score, i + 1);
            for(auto c : words[i]) {
                mp[c] ++;
            }
            return max(op1 , op2);
        }
        return solve(words , mp , score , i + 1);
    }
    bool canMake(string s , unordered_map<char , int> mp) {
        unordered_map<char,int> str_map;
        for(auto c : s) {
            str_map[c] ++;
        }
        for(auto p : str_map){
            char c = p.first;
            if(p.second > mp[c]) return false;
        }
        return true;
    }
};