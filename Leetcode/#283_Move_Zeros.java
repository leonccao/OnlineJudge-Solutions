class Solution {
    public void moveZeroes(int[] nums) {
        int now = 0;
        for (int num : nums)
            if (num != 0)
                nums[now ++] = num;
        while (now < nums.length)
            nums[now ++] = 0;
    }
}