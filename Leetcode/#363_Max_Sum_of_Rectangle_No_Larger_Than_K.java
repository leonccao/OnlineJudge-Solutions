class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row][col];
        
        for (int i = 0; i < row; i ++)
            for (int j = 0; j < col; j ++) {
                sum[i][j] =  matrix[i][j];
                if (j > 0) sum[i][j] += sum[i][j - 1];
            }
        
        int ans = Integer.MIN_VALUE;
        for (int l = 0; l < col; l ++)
            for (int r = l; r < col; r ++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                
                int tmp = 0;
                for (int i = 0; i < row; i ++) {
                    tmp += sum[i][r];
                    if (l > 0) tmp -= sum[i][l - 1];
                    
                    Integer ceil = set.ceiling(tmp - k);
                    if (ceil != null)
                        ans = Math.max(ans, tmp - ceil);
                    set.add(tmp);
                }
            }
        return ans;
    }
}