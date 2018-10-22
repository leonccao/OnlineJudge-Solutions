class Solution {
public:
    int search(vector<int>& nums, int target) {
        if (nums.empty()) return -1;
        nums.push_back(INT_MIN);
        int l = 0, r = nums.size() - 1, line = nums[0];
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= line) l = mid + 1;
            if (nums[mid] < line) r = mid;
        }
        nums.pop_back();
        if (r == nums.size()) {
            l = 0; r = nums.size() - 1;
        } else if (target >= line) {
            l = 0; r --;
        } else r = nums.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) r = mid - 1;
            if (nums[mid] < target) l = mid + 1;
        }
        if (nums[l] == target) return l;
        return -1;
    }
};