class Solution {
    final static int LIMIT = 100000;
    
    private boolean palindrome(long num) {
        String tmp = Long.valueOf(num).toString();
        StringBuilder sb = new StringBuilder(tmp);
        if (tmp.equals(sb.reverse().toString())) return true;
        return false;
    }
    
    public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L);
        long r = Long.valueOf(R);
        int ans = 0;
        for (long i = 1; i <= LIMIT; i ++) {
            StringBuilder sb = new StringBuilder(Long.valueOf(i).toString());
            StringBuilder st = new StringBuilder(Long.valueOf(i).toString());
            
            long num = Long.valueOf(sb.append(st.reverse()).toString());
            long sqr = num * num;
            if (sqr >= l && sqr <= r) {
                if (palindrome(sqr)) {
                    ans ++;
                }
            }
            
            sb.deleteCharAt(sb.length() / 2);
            num = Long.valueOf(sb.toString());
            sqr = num * num;
            if (sqr >= l && sqr <= r) {
                if (palindrome(sqr)) {
                    ans ++;
                }
            }
            if (sqr > r) break;
        }
        return ans;
    }
}