class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int pp = 1;
        int p = nums[0] < nums[1] ? 2 : 1;
        int ans = p;
        
        for (int i = 2; i < nums.length; i ++) {
            int tmp = 1;
            if (nums[i - 2] < nums[i] && pp + 1 > tmp) tmp = pp + 1;
            if (nums[i - 1] < nums[i] && p  + 1 > tmp) tmp = p  + 1;
            ans = Math.max(ans, tmp);
            pp = p; p = tmp;
        }
        
        return ans;
    }
}