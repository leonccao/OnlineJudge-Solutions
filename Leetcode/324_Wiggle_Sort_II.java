class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = n / 2;
        int median = findKth(nums, 0, n - 1, mid);
        
        int start = 0, end = nums.length - 1, cur = 0;
        while (cur <= end) {
            if (nums[map(cur, n)] > median)
                swap(nums, map(cur ++, n), map(start ++, n));
            else if (nums[map(cur, n)] < median)
                swap(nums, map(cur, n), map(end --, n));
            else cur ++;
        }
    }
    
    private int findKth(int[] nums, int start, int end, int k) {
        int mid = nums[end];
        int l, r;
        for (l = start, r = end; l < r; l ++)
            if (nums[l] > mid) 
                swap(nums, l --, -- r);
        swap(nums, l, end);
        if (l == k) return nums[k];
        if (k < l) return findKth(nums, start, l - 1, k);
        return findKth(nums, l + 1, end, k);
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    private int map(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }
}