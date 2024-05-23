class Solution {
public:
    int distributeCoins(TreeNode* root) {
        return solve(root).second;
    }
    pair<int ,int> solve(TreeNode *root) {
        if(root == nullptr) return {0 , 0};
        auto left = solve(root->left);
        auto right = solve(root->right);
        int extraCoin = left.first + right.first + root->val - 1; // extra coin
        int move = left.second + right.second + abs(extraCoin); //move
        return {extraCoin , move};
    }
};