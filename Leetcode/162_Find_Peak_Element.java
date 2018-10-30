class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) 
                r = mid;
            else if (mid + 1 <nums.length && nums[mid + 1] > nums[mid]) 
                l = mid + 1;
            else return mid;
        }
        return l;
    }
}

// new 
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = l + (r - l) / 2 - 1;
            if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            else r = mid + 1;
        }
        return l;
    }
}