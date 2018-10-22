class Solution {
    public int removeDuplicates(int[] nums) {
        int point = 0, cnt = 1;
        for (int i = 1; i < nums.length; i ++) 
            if (nums[i] == nums[point]) {
                if (cnt > 1) continue;
                else {
                    nums[++ point] = nums[i];
                    cnt ++;
                }
            } else {
                nums[++ point] = nums[i];
                cnt = 1;
            }
        return point + 1;
    }
}