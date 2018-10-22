class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0; i <= k; i ++) {
            if (i > nums1.length) break;
            if (k - i > nums2.length) continue;
            int[] tmp = merge(maxArr(nums1, i), maxArr(nums2, k - i));
            if (greater(tmp, 0, ans, 0)) ans = tmp;
        }
        return ans;
    }
    
    public int[] maxArr(int[] nums, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < nums.length; i ++) {
            while (j > 0 && k - j < nums.length - i && nums[i] > ans[j - 1]) j --;
            if (j < k) ans[j ++] = nums[i];
        }
        return ans;
    }
    
    public int[] merge(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        for (int i = 0, j = 0, k = 0; k < a.length + b.length; k ++)
            ans[k] = greater(a, i, b, j) ? a[i ++] : b[j ++];
        return ans;
    }
    
    public boolean greater(int[] a, int ka, int[] b, int kb) {
        while (ka < a.length && kb < b.length && a[ka] == b[kb]) {
            ka ++;
            kb ++;
        }
        return (kb == b.length || (ka < a.length && a[ka] > b[kb]));
    }
}