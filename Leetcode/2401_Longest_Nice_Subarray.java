class Solution {
    public int longestNiceSubarray(int[] nums) {
        int max = 1, tail = 0, cur = 0;
        for (int head = 0; head < nums.length; head++) {
            while ((cur & nums[head]) > 0) {
                cur ^= nums[tail++];
            }
            cur |= nums[head];
            max = Math.max(max, head - tail + 1);
        }
        return max;
    }
}