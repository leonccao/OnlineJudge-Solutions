class Solution {
    public int findLengthOfLCIS(int[] nums, int k) {
        if (nums.length == 0) return 0;
        
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);      // every number itself can be a shortest increasing subsequence
        
        int ans = 1;
        for (int i = 1; i < nums.length; i ++) {
            for (int j = Math.max(0, i - k - 1); j < i; j ++)   // the limit of gap k
                if (nums[i] > nums[j])                          // make sure subsequence is increasing
                    f[i] = Math.max(f[i], f[j] + 1);
            ans = Math.max(ans, f[i]);                  // update result
        }
        return ans;
    }
}