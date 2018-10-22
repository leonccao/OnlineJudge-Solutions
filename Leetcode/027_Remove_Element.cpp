class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.empty()) return 0;
        int pointer = -1;
        for (int i = 0; i < nums.size(); i ++) {
            if (nums[i] != val) {
                nums[++ pointer] = nums[i];
            }
        }
        return pointer + 1;
    }
};