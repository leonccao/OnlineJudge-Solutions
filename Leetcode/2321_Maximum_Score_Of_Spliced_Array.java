class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(getMax(nums1, nums2), 
                        getMax(nums2, nums1));
    }
    
    private int getMax(int[] a, int[] b) {
        
        int sum = 0;
        for (int nums : a) {
            sum += nums;
        }
        
        int n = a.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = b[i] - a[i];
        }
        int min = 0;
        int sumDiff = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            sumDiff += diff[i];
            maxSum = Math.max(maxSum, sumDiff - min);
            min = Math.min(min, sumDiff);
        }
        return sum + maxSum;
    }
}