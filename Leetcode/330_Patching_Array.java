class Solution {
    public int minPatches(int[] nums, int n) {
        long found = 0;
        int ans = 0;
        int index = 0;
        while (found < n) {
            if (index < nums.length && nums[index] <= found + 1)
                found += nums[index ++];
            else {
                found = found * 2 + 1;
                ans ++;
            }
        }
        return ans;
    }
}