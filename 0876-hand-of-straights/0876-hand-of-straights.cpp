class Solution {
public:
    bool isNStraightHand(vector<int>& hand, int groupSize) {
        if(hand.size() % groupSize != 0) return false;
        int size = hand.size() / groupSize;
        map<int,int> mp;
        for(int i : hand) mp[i] ++;
        while (!mp.empty()) {
            int currCard = mp.begin()->first;
            for (int i = 0; i < groupSize; i++) {
                if (mp[currCard + i] == 0)  return false;
                mp[currCard + i] --;
                if (mp[currCard + i] < 1) mp.erase(currCard + i);
            }
        }
        return true;
    }
};