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

class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        for (int k = 0; k <= j; k ++) {
            while (i <= j && nums[i] == 0) ++ i;
            while (i <= j && nums[j] == 2) -- j;
            if (k < i) k = i;
            if (k > j) break;
            if (nums[k] == 0) swap(nums, i, k --);
            else if (nums[k] == 2) swap(nums, k --, j);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}