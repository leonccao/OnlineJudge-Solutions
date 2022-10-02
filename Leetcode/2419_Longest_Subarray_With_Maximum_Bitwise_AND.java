class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int count = 0, maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxNum) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    count = 1;
                } else {
                    count++;
                }
            } else { 
                count = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}