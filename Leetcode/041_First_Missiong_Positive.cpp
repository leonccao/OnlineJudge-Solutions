class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        bool changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < nums.size(); i ++) {
                if (nums[i] > nums.size()) continue;
                if (nums[i] <= 0) continue;
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums[i], nums[nums[i] - 1]);
                    changed = true;
                }
            }
        }
        
        for (int i = 0; i < nums.size(); i ++)
            if (nums[i] != i + 1)
                return i + 1;
        return nums.size() + 1;
    }
};