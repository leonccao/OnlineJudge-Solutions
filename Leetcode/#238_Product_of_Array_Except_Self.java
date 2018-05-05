class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int mul = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            mul *= nums[i];
            ans[i + 1] *= mul;
        }
        mul = 1;
        for (int i = nums.length - 1; i > 0; i --) {
            mul *= nums[i];
            ans[i - 1] *= mul;
        }
        return ans;
    }
}