class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            int[] rtn = {-1, -1};
            return rtn;
        }
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2 - 1;
            if (nums[mid] == target) r = mid + 1;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) {
            int[] rtn = {-1, -1};
            return rtn;
        }
        int[] rtn = new int[2];
        rtn[0] = l;
        l = 0; r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) l = mid;
            else if (nums[mid] > target) r = mid;
            else l = mid + 1;
        }
        rtn[1] = l;
        return rtn;
    }
}