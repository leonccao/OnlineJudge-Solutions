
class Solution {
private:
    int helper(TreeNode* root, vector<vector<int>>& res) {
        if (!root) return 0;
        int level = max(helper(root->left, res), helper(root->right, res)) + 1;
        if (level > res.size()) res.push_back(vector<int>());
        res[level - 1].push_back(root->val);
        return level;
    }
    
public:
    vector<vector<int>> findLeaves(TreeNode* root) {
        vector<vector<int>> res;
        helper(root, res);
        return res;
    }
};