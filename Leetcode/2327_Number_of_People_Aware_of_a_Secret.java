class Solution {
    long MOD = 1000000000 + 7;
    
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] d = new int[delay + 1];
        int[] f = new int[forget + 1];
        long aware = 1;
        long distribute = 0;
        
        d[delay] = 1;
        f[forget] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < delay; j++) {
                d[j] = d[j + 1];
            }
            for (int j = 0; j < forget; j++) {
                f[j] = f[j + 1];
            }
            distribute = (distribute + d[0] - f[0] + MOD) % MOD;
            aware = (aware + distribute - f[0] + MOD) % MOD;
            d[delay] = (int)distribute;
            f[forget] = (int)distribute;
        }
        return (int)aware;
    }
}