class Solution {
    
    private int weight(int[] A, int i, int j, int k) {
        return A[i] * A[j] * A[k];
    }
    
    public int minScoreTriangulation(int[] A) {
        int[][] f = new int[A.length][A.length];
        for (int i = A.length - 1; i > 0; i --)
            for (int j = i + 1; j < A.length; j ++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k ++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k + 1][j] + weight(A, i - 1, k, j));
                }
            }
        
        return f[1][A.length - 1];
    }
}