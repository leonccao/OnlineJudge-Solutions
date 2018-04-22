class Solution {
    
    final static int MOD = 1000000000 + 7;
    
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i ++)
            map.put(A[i], i);
        
        long[] ways = new long[A.length];
        Arrays.fill(ways, 1);
        long ans = 0;
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (A[i] % A[j] != 0) continue;
                if (!map.containsKey(A[i] / A[j])) continue;
                int k = map.get(A[i] / A[j]);
                ways[i] = (ways[j] * ways[k] + ways[i]) % MOD;
            }
            ans = (ans + ways[i]) % MOD;
            // System.out.println(ways[i]);
        }
        
        return (int)ans;
    }
}