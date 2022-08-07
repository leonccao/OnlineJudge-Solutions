class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        
        int[][] f = new int[n][26];
        f[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            for (int j = 0; j < 26; j++) {
                f[i][j] = f[i - 1][j];
            }
            for (int j = 0; j < 26; j++) {
                if (Math.abs(cur - j) <= k) {
                    f[i][cur] = Math.max(f[i][cur], f[i - 1][j] + 1);
                }
            }
        }
        
        int result = 1;
        for (int j = 0; j < 26; j++) {
            result = Math.max(result, f[n - 1][j]);
        }
        return result;
    }
}