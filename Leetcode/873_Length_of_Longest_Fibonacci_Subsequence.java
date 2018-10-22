class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        int[][] f = new int[len][len];
        for (int i = 0; i < len; i ++)
            for (int j = i + 1; j < len; j ++)
                f[i][j] = 2;
        
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (!map.containsKey(A[j] - A[i])) continue;
                int k = map.get(A[j] - A[i]);
                f[i][j] = f[k][i] + 1;
                ans = Math.max(ans, f[i][j]);
            }
            map.put(A[i], i);
        }
        return ans;
    }
}