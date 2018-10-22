class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2, -1);
        if (nums.empty()) return result;
        
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        int L = l;
        l = 0; r = nums.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        int R = l;
        
        if (nums[L] != target) return result;
        result[0] = L;
        result[1] = R;
        return result;
    }
};