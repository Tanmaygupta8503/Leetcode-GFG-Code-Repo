class Solution {
public:
int move = 0;
    int distributeCoins(TreeNode* root) {
        solve(root);
        return move; 
    }
    int solve(TreeNode *root) {
        if(root == nullptr) return 0;
        auto left = solve(root->left);
        auto right = solve(root->right);
        int extraCoin = left + right + root->val - 1; // extra coin
        move += abs(extraCoin); //move
        return extraCoin;
    }
};
class Solution2 {
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
