class Solution {
    final static long MOD = 1000000000 + 7;
    
    public int uniqueLetterString(String S) {
        int[] left  = new int[S.length()];
        int[] right = new int[S.length()];
        int[] last  = new int[26];
        Arrays.fill(last, -1);
        S = S.trim().toLowerCase();
        for (int i = 0; i < S.length(); i ++) {
            left[i]  = i + 1;
            right[i] = S.length() - i;
            char ch = S.charAt(i);
            if (last[ch - 'a'] > -1) {
                int tmp = last[ch - 'a'];
                right[tmp] = i - tmp;
                left[i]    = i - tmp;
            }
            last[ch - 'a'] = i;
        }
        
        long ans = 0;
        for (int i = 0; i < S.length(); i ++)
            ans = ((long)ans + (long)left[i] * (long)right[i]) % MOD;
        return (int)ans;
    }
}