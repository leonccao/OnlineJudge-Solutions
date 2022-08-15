class Solution {
    int res = 0;
    
    
    public int countSpecialNumbers(int n) {
        
        char[] chs = Integer.toString(n).toCharArray();
        int len = chs.length;
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = chs[i] - '0';
        }
        
        long res = 0;
        boolean[] v = new boolean[10];
        
        long[] fac = new long[11];
        fac[0] = 1;
        for (int i = 1; i < 11; i++) {
            fac[i] = fac[i - 1] * i;
        }
        
        boolean special = true;
        for (int index = 0; index < len; index++) {
            int cur = digits[index];
            
            int count = cur;
            for (int i = 0; i < cur; i++) {
                if (v[i]) {
                    count--;
                }
            }
            if (index == 0) {
                count--;
            }
            
            int space = 9 - index;
            if (count > 0 && special) {
                res += fac[space] / fac[space - len + index + 1] * count;
            }
        
            if (index < len - 1) {
                res += fac[9] / fac[11 - len + index] * 9;
            }
            
            // Check duplicate digits
            if (v[cur]) {
                special = false;
            }
            v[cur] = true;
        }
        
        if (special) {
            res++;
        }
        
        
        return (int)res;
    }
}