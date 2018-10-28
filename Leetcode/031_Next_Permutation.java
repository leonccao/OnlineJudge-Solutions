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

// new
class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) index --;
        if (index > 0) {
            int tmp = binarySearch(nums, index, nums.length - 1, nums[index - 1]);
            swap(nums, index - 1, tmp);
        }
        for (int i = index; i <= (index + nums.length - 1) / 2; i ++)
            swap(nums, i, index + nums.length - i - 1);
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        int l = start, r = end + 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) l = mid;
            else r = mid;
        }
        return l;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}