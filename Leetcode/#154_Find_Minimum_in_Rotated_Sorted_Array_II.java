class Solution {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++)
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        return nums[0];
    }
}