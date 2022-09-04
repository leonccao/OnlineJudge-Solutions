class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base < n - 1; base++) {
            int cur = n;
            StringBuilder sb = new StringBuilder();
            while (cur > 0) {
                sb.append(cur % base);
                cur /= base;
            }
            StringBuilder sbr = new StringBuilder(sb);
            String s = sb.toString();
            String sr = sbr.reverse().toString();
            if (!s.equals(sr)) {
                return false;
            }
        }
        return true;
    }
}