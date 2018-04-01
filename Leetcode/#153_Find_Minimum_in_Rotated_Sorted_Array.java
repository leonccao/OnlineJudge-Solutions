class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int gap = 1;
        int base = 0;
        while (gap > 0) {
            if (base + gap < nums.length && nums[base + gap] > nums[0]) {
                base += gap;
                gap *= 2;
            } else {
                gap /= 2;
            }
        }
        if (base == nums.length - 1)
            return nums[0];
        else return nums[base + 1];
    }
}