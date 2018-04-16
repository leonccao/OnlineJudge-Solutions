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