class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[r];
            nums[r --] = nums[l];
            nums[l ++] = tmp;
        }
    }
}