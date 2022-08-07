class Solution {
    public boolean validPartition(int[] nums) {
        
        boolean[] f = new boolean[nums.length + 1];
        f[0] = true;
        for (int i = 2; i <= nums.length; i++) {
            int index = i - 1;
            if (nums[index] == nums[index - 1]) {
                f[i] |= f[i - 2];
            }
            if (index > 1 &&
               nums[index] == nums[index - 1] &&
               nums[index] == nums[index - 2]) {
                f[i] |= f[i - 3];
            }
            if (index > 1 &&
               nums[index] == nums[index - 1] + 1 &&
               nums[index] == nums[index - 2] + 2) {
                f[i] |= f[i - 3];
            }
        }
        return f[nums.length];
    }
}