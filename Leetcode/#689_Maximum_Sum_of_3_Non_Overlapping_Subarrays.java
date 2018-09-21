/*
### Corner cases
1. nums.length < 3 * k
2. nums[i] <= 0

### Solution 
1. DP
    f[n][3] 
    f[i][j] = Math.max(f[i - 1][j], f[i - k][j - 1] + sum[i] - sum[i - k])
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs
1. Return the result as a list of indices representing the starting position of each interval.
2. If there are multiple answers, return the lexicographically smallest one.

### Test cases
1. [1, 2, 1, 2, 6, 7, 5, 1]
       3  3  3  8 13 13 13
             6 11 16 21 21
                  19 23 23

*/
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length];
        // prepare sum[]
        for (int i = 0; i < nums.length; i ++)
            sum[i] = i == 0 ? nums[i] : sum[i - 1] + nums[i];
        // prepare sumk[]
        int[] sumk = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i < k - 1)
                sumk[i] = 0;
            else if (i == k - 1)
                sumk[i] = sum[i];
            else sumk[i] = sum[i] - sum[i - k];
        }
        
        // DP
        int[][] f = new int[nums.length][4];
        int[][][] rec = new int[nums.length][4][3];
        
        f[k - 1][1] = sumk[k - 1];
        rec[k - 1][1][0] = 0;
        for (int i = k; i < nums.length; i ++) {
            for (int j = 1; j < 4; j ++) {
                // f[i][j] = Math.max(f[i - 1][j], f[i - k][j - 1] + sumk[i]);
                if (f[i - 1][j] >= f[i - k][j - 1] + sumk[i]) {
                    f[i][j] = f[i - 1][j];
                    for (int tmp = 0; tmp < j; tmp ++)
                        rec[i][j][tmp] = rec[i - 1][j][tmp];
                } else {
                    f[i][j] = f[i - k][j - 1] + sumk[i];
                    for (int tmp = 0; tmp < j - 1; tmp ++)
                        rec[i][j][tmp] = rec[i - k][j - 1][tmp];
                    rec[i][j][j - 1] = i - k + 1;
                }
            }
        }
        return rec[nums.length - 1][3];
    }
}