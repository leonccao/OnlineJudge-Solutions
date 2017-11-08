class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> twoSum;
        bool flag = false;
        for (int i = 0; i < nums.size(); i ++) {
            for (int j = i + 1; j < nums.size(); j ++)
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    twoSum.push_back(i);
                    twoSum.push_back(j);
                    break;
                }
            if (flag) break;
        }
        return twoSum;
    }
};