class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, head = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            while (sum - nums[head] >= s)
                sum -= nums[head ++];
            if (sum >= s) ans = Math.min(ans, i - head + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}