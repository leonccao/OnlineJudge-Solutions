class Solution {
    final static int MOD = 1000000000 + 7;
    public int distinctSubseqII(String S) {
        Map<Character, Integer> map = new HashMap<>();
        int[] f = new int[S.length()];
        f[0] = 1;
        map.put(S.charAt(0), 0);
        for (int i = 1; i < S.length(); i ++) {
            f[i] = 1;
            for (char key : map.keySet()) {
                f[i] = (f[i] + f[map.get(key)]) % MOD;
            }
            map.put(S.charAt(i), i);
        }
        int ans = 0;
        for (char key : map.keySet()) 
            ans = (ans + f[map.get(key)]) % MOD;
        return ans;
    }
}