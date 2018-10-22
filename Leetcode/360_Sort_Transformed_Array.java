/*
### Corner cases
1. a == 0 -> b > 0; b < 0; b == 0
2. -b/2a < nums[0] or > nums[length - 1]
3. a < 0

### Solution
1. Calculate (-b / 2a), then two pointer one forewards another backwards.
    - Time complexity: O(n)
    - Space complexity: O(n)

*/
class Solution {
    
    private int calc(int num, int a, int b, int c) {
        return a * num * num + b * num + c;   
    }
    
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int l = nums.length - 1;
        int r = nums.length;
        if (a == 0) {
            if (b >= 0) {
                l = -1;
                r = 0;
            }
            // otherwise l, r should be the initialize value
        } else {
            if (a > 0) {
                double mid = - (double)b / 2 / a;
                for (int i = 0; i < nums.length; i ++) {
                    if (nums[i] > mid) {
                        l = i - 1;
                        r = i;
                        break;
                    }
                }     
            } else {
                l = nums.length - 1;
                r = 0;
            }
        }
        
        int[] ans = new int[nums.length];
        int pos = 0;
        while (pos < ans.length) {
            if (l < 0) {
                ans[pos ++] = calc(nums[r ++], a, b, c);
            } else if (r >= nums.length) {
                ans[pos ++] = calc(nums[l --], a, b, c);
            } else {
                int p = calc(nums[l], a, b, c);
                int q = calc(nums[r], a, b, c);
                if (p < q) {
                    ans[pos ++] = p;
                    l --;
                } else {
                    ans[pos ++] = q;
                    r ++;
                }
            }
        }
        return ans;
    }
}