class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> res;
        vector<int> ans;
        solve(res, candidates, 0, target, 0, ans);
        return res;
    }
    void solve(vector<vector<int>>& res, vector<int>& candidates, int start, int target, int sum, vector<int>& ans) {
        if (sum == target) {
            res.push_back(ans);
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            ans.push_back(candidates[i]);
            solve(res, candidates, i + 1, target, sum + candidates[i], ans);
            ans.pop_back();
        }
    }
};