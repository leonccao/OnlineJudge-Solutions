class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int[] len = new int[n + 1];
        int[] val = new int[n + 1];
        int result = 1;
        len[n] = 0;
        val[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            
            long digit = s.charAt(i) - '0';
            
            for (int j = i + 1; j <= n; j++) {
                if (digit > 0 && len[j] > 32) {
                    continue;
                }
                int newLen = len[j] + 1;
                long newVal = digit > 0 ? 
                    (long)val[j] + (digit << len[j]) :
                    val[j];
                
                if (newLen < len[i] || newVal > k) {
                    continue;
                }
                
                if (newLen > len[i] ||
                   (newLen == len[i] && newVal < val[i])) {
                    len[i] = newLen;
                    val[i] = (int)newVal;
                }
                
            }
            result = Math.max(result, len[i]);
        }
        return result;
    }
}