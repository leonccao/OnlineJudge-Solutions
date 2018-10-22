class Solution {
    int base = -1, len;
    public int c(int obj) {
        return (obj + base) % len;
    }
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        
        int minn = Integer.MAX_VALUE;
        len = nums.length;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] < minn ||
               (nums[i] == minn && nums[i - 1] != minn)) {
                minn = nums[i];
                base = i;
            }
        
        
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[c(mid)] == target)
                return true;
            if (nums[c(mid)] < target)
                l = mid + 1;
            else r = mid;
        }
        if (nums[c(l)] == target)
            return true;
        return false;
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return true;
            if (nums[l] < nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid;
                else l = mid;
            } else if (nums[mid] <= nums[r - 1]) {
                if (target > nums[mid] && target <= nums[r - 1])
                    l = mid;
                else r = mid;
            } else l ++;
        }
        if (nums[l] == target) return true;
        return false;
    }
}