class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] f = new int[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; i ++)
            for (int j = 0; j <= B.length; j ++)
                f[i][j] = Integer.MIN_VALUE / 2;
        f[0][0] = 0;
        for (int i = 0; i <= A.length; i ++)
            f[i][0] = 0;
        for (int j = 0; j <= B.length; j ++)
            f[0][j] = 0;
        
        for (int i = 1; i <= A.length; i ++) {
            for (int j = 1; j <= B.length; j ++) {
                if (A[i - 1] == B[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
                f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                f[i][j] = Math.max(f[i][j], f[i][j - 1]);
            }
        }
        return f[A.length][B.length];
    }
}