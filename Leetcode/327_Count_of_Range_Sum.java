class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i ++)
            sum[i + 1] = sum[i] + nums[i];
        
        int ans = count(sum, 0, sum.length, lower, upper);
        return ans;
    }
    
    private int count(long[] sum, int start, int end, int lower, int upper) {
        if (start >= end - 1) return 0;
        int mid = (start + end) / 2;
        int ans = count(sum, start, mid, lower, upper) + count(sum, mid, end, lower, upper);
        
        int rightLow, rightHigh;
        rightLow = rightHigh = mid;
        for (int left = start; left < mid; left ++) {
            while (rightLow  < end && sum[rightLow]  - sum[left] <  lower) rightLow  ++;
            while (rightHigh < end && sum[rightHigh] - sum[left] <= upper) rightHigh ++;
            ans += rightHigh - rightLow;
        }
        
        long[] tmp = new long[end - start];
        for (int k = 0, i = start, j = mid; k < end - start; k ++)
            tmp[k] = (j < end && (i == mid || sum[j] < sum[i])) ? sum[j ++] : sum[i ++];
        for (int k = start; k < end; k ++)
            sum[k] = tmp[k - start];
        return ans;
    }
}