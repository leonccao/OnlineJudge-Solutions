class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] corner = new int[matrix.length][matrix[0].length];
        int[][] left   = new int[matrix.length][matrix[0].length];
        int[][] up     = new int[matrix.length][matrix[0].length];
        
        int ans = 0;
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[0].length; j ++) {
                if (matrix[i][j] == '0') continue;
                left[i][j] = up[i][j] = corner[i][j] = 1;
                if (i > 0) up[i][j]   = up[i - 1][j]   + 1;
                if (j > 0) left[i][j] = left[i][j - 1] + 1;
                if (i > 0 && j > 0)
                    corner[i][j] = Math.min(corner[i - 1][j - 1] + 1,
                                           Math.min(left[i][j], up[i][j]));
                ans = Math.max(ans, corner[i][j]);
            }
        return ans * ans;
    }
}