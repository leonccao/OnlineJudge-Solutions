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

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != 0) {
                if (i == j) j ++;
                else {
                    nums[j ++] = nums[i];
                    nums[i] = 0;
                }
            }
    }
}