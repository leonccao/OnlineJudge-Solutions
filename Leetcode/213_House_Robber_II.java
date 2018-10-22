class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) 
            return Math.max(nums[0], nums[1]);
        
        int[] brk = new int[nums.length];
        int[] ign = new int[nums.length];
        
        brk[0] = nums[0];
        ign[0] = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i ++) {
            brk[i] = ign[i - 1] + nums[i];
            ign[i] = Math.max(brk[i - 1], ign[i - 1]);
        }
        int ans = Math.max(brk[nums.length - 2], ign[nums.length - 2]);
        
        brk[0] = Integer.MIN_VALUE;
        ign[0] = 0;
        for (int i = 1; i < nums.length; i ++) {
            brk[i] = ign[i - 1] + nums[i];
            ign[i] = Math.max(brk[i - 1], ign[i - 1]);
        }
        ans = Math.max(ans, Math.max(brk[nums.length - 1], ign[nums.length - 1]));
        return ans;
    }
}