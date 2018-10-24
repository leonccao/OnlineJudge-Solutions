class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 1, ans = 1;
        for (int i = 1; i < nums.length; i ++)
            if (nums[i] > nums[i - 1])
                ans = Math.max(ans, ++ len);
            else len = 1;
        return ans;
    }
}