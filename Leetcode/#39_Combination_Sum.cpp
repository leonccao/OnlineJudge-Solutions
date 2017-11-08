class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> tmp;
        vector<vector<int>> result;
        sort(candidates.begin(), candidates.end());
        search(0, target, candidates, tmp, result);
        return result;
    }
    void search(int pos, int remain, vector<int>& candidates, vector<int>& tmp, vector<vector<int>>& result) {
        if (remain == 0)
            result.push_back(tmp);
        if (remain <= 0) return;
        
        for (int i = pos; i < candidates.size(); i ++) {
            if (remain < candidates[i]) break;
            tmp.push_back(candidates[i]);
            search(i, remain - candidates[i], candidates, tmp, result);
            tmp.pop_back();
        }
    }
};