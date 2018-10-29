class NumMatrix {

    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[0].length; j ++)
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}

// new 
class NumMatrix {

    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[0].length; j ++)
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}