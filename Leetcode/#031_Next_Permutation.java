/*
Bugs:
1. For-loop
2. Input may have duplicates, binary search should be minded
*/
class Solution {
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1; i > 0; i --)
            if (nums[i] > nums[i - 1])
                break;
        if (i > 0) {
            int l = i, r = nums.length;
            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (nums[mid] <= nums[i - 1])
                    r = mid;
                else l = mid;
            }
            swap(nums, i - 1, l);
        }
        int len = (nums.length - i) / 2;
        for (int j = 0; j < len; j ++)
            swap(nums, i + j, nums.length - j - 1);
    }
}