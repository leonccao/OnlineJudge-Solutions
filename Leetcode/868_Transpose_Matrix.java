class Solution {
    public int[][] transpose(int[][] A) {
        int row = A[0].length;
        int col = A.length;
        
        int[][] B = new int[row][col];
        for (int i = 0; i < row; i ++)
            for (int j = 0; j < col; j ++)
                B[i][j] = A[j][i];
        
        return B;
    }
}