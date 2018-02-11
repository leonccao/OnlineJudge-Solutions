class Solution {
    public int missingNumber(int[] nums) {
        int tmp = nums.length;
        for (int i = 0; i < nums.length; i ++)
            tmp = tmp ^ i ^ nums[i];
        return tmp;
    }
}