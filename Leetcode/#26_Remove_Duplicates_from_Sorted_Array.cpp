class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        int pointer = 0;
        for (int i = 0; i < nums.size(); i ++) {
            if (nums[i] != nums[pointer]) {
                nums[++ pointer] = nums[i];
            }
        }
        return pointer + 1;
    }
};