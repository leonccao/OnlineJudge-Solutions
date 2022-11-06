class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long sum = 0, result = 0;
        int cnt = 0;
        int[] rec = new int[100001];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if ((rec[nums[i]]++) == 0) {
                cnt++;
            }
            
            if (i < k - 1) {
                continue;
            }
            
            if (i > k - 1) {
                sum -= nums[i - k];
                if ((--rec[nums[i - k]]) == 0) {
                    cnt--;
                }
            }
            if (cnt == k) {
                result = Math.max(result, sum);
            }
        }
        return result;
    }
}