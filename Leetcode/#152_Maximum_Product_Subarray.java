class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int mul = 1, minp = 1, maxn = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                mul = 1;
                minp = 1;
                maxn = Integer.MIN_VALUE;
                ans = Math.max(ans, 0);
                continue;
            }
            
            mul *= nums[i];
            if (mul > 0) {
                ans = Math.max(ans, mul / minp);
                minp = Math.min(minp, mul);
            } else {
                if (maxn > Integer.MIN_VALUE)
                    ans = Math.max(ans, mul / maxn);
                ans = Math.max(ans, mul / minp);
                maxn = Math.max(maxn, mul);
            }
        }
        
        return ans;
    }
}