class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        vector<vector<int>> subsets;
        vector<int> current;
        generateSubsets(nums, 0, current, subsets);
        int sum = 0;
        for(auto vec : subsets) {
            int xorr = 0;
            for(int i : vec) {
                xorr ^= i;
            }
            sum += xorr;
        }
        return sum;
    }
    void generateSubsets(const vector<int>& nums, int index, vector<int>& current, vector<vector<int>>& subsets) {
        if (index == nums.size()) {
            subsets.push_back(current);
            return;
        }
        current.push_back(nums[index]);
        generateSubsets(nums, index + 1, current, subsets);
        current.pop_back();
        generateSubsets(nums, index + 1, current, subsets);
    }
};
