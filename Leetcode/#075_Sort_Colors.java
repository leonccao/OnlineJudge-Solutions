/*
class Solution {
    public void sortColors(int[] nums) {
        int[] total = new int[3];
        for (int num : nums)
            total[num] ++;
        for (int i = 0; i < total[0]; i ++)
            nums[i] = 0;
        for (int i = total[0]; i < total[0] + total[1]; i ++)
            nums[i] = 1;
        for (int i = total[0] + total[1]; i < total[0] + total[1] + total[2]; i ++)
            nums[i] = 2;
    }
}
*/
class Solution {
    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1;
        for (int i = 0; i <= tail; i ++) {
            if (nums[i] == 0) {
                nums[i] = nums[head];
                nums[head ++] = 0;
            }
            if (nums[i] == 2) {
                nums[i --] = nums[tail];
                nums[tail --] = 2;
            }
        }
    }
}