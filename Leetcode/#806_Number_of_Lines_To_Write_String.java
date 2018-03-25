class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int[] result = {0, 0};
        if (S.equals("") || S.length() == 0) return result;
        
        int ans = 1, sign = 0, left = 100;
        while (sign < S.length()) {
            char ch = S.charAt(sign);
            int tmp = widths[ch - 'a'];
            if (tmp > 100) break;
            if (tmp > left) {
                ans ++;
                left = 100;
            } else {
                left -= tmp;
                sign ++;
            }
        }
        result[0] = ans;
        result[1] = 100 - left;
        return result;
    }
}