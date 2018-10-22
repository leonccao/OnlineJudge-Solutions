class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        nums.push_back(INT_MIN);
        int found = 0;
        for (int i = nums.size() - 2; i > 0; i --)
            if (nums[i - 1] < nums[i]) {
                found = i;
                break;
            }
        
        nums.pop_back();
        if (!found) sort(nums.begin(), nums.end());
        else {
            int k = found;
            for (int i = found; i < nums.size(); i ++)
                if (nums[i] > nums[found - 1] && nums[i] < nums[k])
                    k = i;
            swap(nums[found - 1], nums[k]);
            sort(nums.begin() + found, nums.end());
        }
    }
};