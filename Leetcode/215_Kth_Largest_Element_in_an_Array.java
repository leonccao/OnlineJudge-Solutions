class Solution {
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    private int findkth(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        int pivot = nums[r];
        int i = l, j = r - 1;
        do {
            while (i < r && nums[i] > pivot) i ++;
            while (l < j && nums[j] < pivot) j --;
            if (i < j) swap(nums, i ++, j --);
        } while (i < j);
        swap(nums, i, r);
        
        if (i == k) return nums[i];
        if (k < i) return findkth(nums, l, i - 1, k);
        else return findkth(nums, i + 1, r, k);
    }
    
    public int findKthLargest(int[] nums, int k) {
        return findkth(nums, 0, nums.length - 1, k - 1);
    }
}


// Quick selection new
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    
    private int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[l];
        int pivot = nums[r];
        int i = l, j = r - 1;
        do {
            while (i < r && nums[i] > pivot) i ++;
            while (l < j && nums[j] < pivot) j --;
            if (i < j) swap(nums, i ++, j --);
        } while (i < j);
        swap(nums, i, r);
        if (i == k) return nums[i];
        if (k < i) return quickSelect(nums, l, i - 1, k);
        else return quickSelect(nums, i + 1, r, k);
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}