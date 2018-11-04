class Solution {
public:
    vector<int> getModifiedArray(int length, vector<vector<int>>& updates) {
        vector<int> nums(length + 1, 0);
        for (auto& tuple : updates) {
            nums[tuple[0]] += tuple[2];
            nums[tuple[1] + 1] -= tuple[2];
        }
        int sum = 0;
        vector<int> res;
        for (int i = 0; i < length; i ++) {
            sum += nums[i];
            res.push_back(sum);
        }
        return res;
    }
};