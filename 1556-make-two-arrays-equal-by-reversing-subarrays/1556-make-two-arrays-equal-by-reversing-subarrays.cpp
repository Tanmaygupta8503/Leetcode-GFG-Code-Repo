class Solution {
public:
    bool canBeEqual(vector<int>& target, vector<int>& arr) {
        unordered_map<int, int> map;
        for (int i = 0; i < arr.size(); ++i) {
            map[arr[i]]++;
            map[target[i]]--;
        }
        for (const auto& kv : map) {
            if (kv.second != 0) {
                return false;
            }
        }
        return true;
    }
};
