class NumMatrix {
    private int[][] sum, copy;

    public NumMatrix(int[][] matrix) {
        if (matrix.length <= 0) return;
        
        copy = matrix.clone();
        
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++) {
                binaryInsert(i + 1, j + 1, matrix[i][j]);
            }
        }
    }
    
    private int lowbit(int index) {
        return index & (-index);
    }
    
    private void binaryInsert(int row, int col, int delta) {
        for (int i = row; i < sum.length; i += lowbit(i)) {
            for (int j = col; j < sum[0].length; j += lowbit(j)) {
                sum[i][j] += delta;
            }
        }
    }
    
    private int binarySearch(int row, int col) {
        int result = 0;
        for (int i = row; i > 0; i -= lowbit(i)) {
            for (int j = col; j > 0; j -= lowbit(j)) {
                result += sum[i][j];
            }
        }
        return result;
    }
    
    public void update(int row, int col, int val) {
        int delta = val - copy[row][col];
        copy[row][col] = val;
        binaryInsert(row + 1, col + 1, delta);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return binarySearch(row2 + 1, col2 + 1)
             - binarySearch(row2 + 1, col1    )
             - binarySearch(row1    , col2 + 1)
             + binarySearch(row1    , col1    );
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */