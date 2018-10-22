class Solution {
    public int maxSubArray(int[] nums) {
        int prefix = 0, sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            ans = Math.max(ans, sum - prefix);
            prefix = Math.min(prefix, sum);
        }
        return ans;
    }
}