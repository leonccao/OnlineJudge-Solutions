class Solution {
    
    final static int MOD = 1000000000 + 7;
    
    public int numDecodings(String s) {
        long[] f = new long[s.length() + 1];
        f[0] = 1;
        char last = '$';
        for (int i = 0; i < s.length(); i ++) {
            char cur = s.charAt(i);
            
            if (cur == '*') f[i + 1] += f[i] * 9;
            else if (cur > '0') f[i + 1] += f[i];
        
            if (i > 0) {
                if (last == '*') {
                    if (cur == '*') f[i + 1] += 15 * f[i - 1];
                    else if (cur > '6') f[i + 1] += f[i - 1];
                    else f[i + 1] += 2 * f[i - 1];
                } else if (cur == '*') {
                    if (last == '1') f[i + 1] += 9 * f[i - 1];
                    else if (last == '2') f[i + 1] += 6 * f[i - 1];
                } else {
                    int tmp = (last - '0') * 10 + (cur - '0');
                    if (tmp >= 10 && tmp <= 26) f[i + 1] += f[i - 1];
                }
            }
            
            f[i + 1] %= MOD;
            last = cur;
        }
        return (int)f[s.length()];
    }
}