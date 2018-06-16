class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        
        int k = 0;
        OUT_LOOP:
            while (true) {
                for (int i = 1 << k; i < (1 << (k + 1)); i ++) {
                    if (i > num) break OUT_LOOP;
                    ans[i] = ans[i - (1 << k)] + 1;
                }
                k ++;
            }
        return ans;
    }
}