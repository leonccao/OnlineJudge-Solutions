/*
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, k - 1);
    }
    
    private int findKth(int[] nums, int s, int e, int k) {
        if (s == e) return nums[s];
        int mid = nums[e];
        int l, r;
        for (l = s, r = e; l < r; l ++) {
            if (nums[l] < mid) swap(nums, l --, -- r);
        }
        swap(nums, l, e);
        if (l == k) return nums[l];
        if (k < l) return findKth(nums, s, l - 1, k);
        else return findKth(nums, l + 1, e, k);
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}