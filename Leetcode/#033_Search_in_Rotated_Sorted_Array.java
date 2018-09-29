/*
Bugs:
1. `nums[mid] <= nums[r - 1]` because mid may equals to (r - 1)
2. Input maybe empty
*/
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[l] < nums[mid]) { 
                if (target >= nums[l] && target < nums[mid])
                    r = mid;
                else l = mid;
            } else if (nums[mid] <= nums[r - 1]) { // !
                if (target > nums[mid] && target <= nums[r - 1])
                    l = mid;
                else r = mid;
            }
        }
        if (nums[l] == target) return l;
        return -1;
    }
}