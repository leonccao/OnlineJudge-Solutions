class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        int[][] f = new int[nums.length][2];
        f[0][0] = 0;
        f[0][1] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        int l = nums.length - 1;
        return Math.max(f[l][0], f[l][1]);
    }
}