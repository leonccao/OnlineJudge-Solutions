class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
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
        if (pos == candidates.size()) return;
        
        int l = pos, r = pos, cnt = 0;
        while (r < candidates.size() && candidates[r] == candidates[l]) r ++;
        for (int i = 0; i <= r - l; i ++) {
            if (remain < candidates[l] * i) break;
            if (i) {
                tmp.push_back(candidates[l]);
                cnt ++;
            }
            search(r, remain - candidates[l] * i, candidates, tmp, result);
        }
        while (cnt --) tmp.pop_back();
    }
};