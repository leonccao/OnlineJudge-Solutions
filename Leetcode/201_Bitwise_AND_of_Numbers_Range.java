class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        /*
        int high = Integer.highestOneBit(m);
        int ans = 0;
        int tmp = (m | (high << 1)) > 0 ? (m | (high << 1)) : Integer.MAX_VALUE;
        if (n > tmp) return 0;
        outer:
        for (int k = 1; k <= high && k > 0; k <<= 1) {
            for (int i = m; i <= n && i > 0; i ++)
                if ((k & i) == 0)
                    continue outer;
            ans |= k;
        }
        return ans;
        */
        
        int offset = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m <<= offset;
    }
}