class Solution {
public:
    int minimumDeletions(string s) {
        int mini = INT_MAX , a = 0 , b = 0;
        for(char c : s) if(c == 'a') a ++;
        for (char c : s) {
            int tempB = b;
            if(c == 'a') a --;
            if(c == 'b') b ++;
            mini = min(mini, a + tempB);
        }
        return mini;
    }
};
