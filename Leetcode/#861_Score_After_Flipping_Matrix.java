class Solution {
    public int matrixScore(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i ++)
            if (A[i][0] == 0)
                for (int j = 0; j < col; j ++)
                    A[i][j] = 1 - A[i][j];
        
        int base = 1 << col - 1;
        int ans = 0;
        for (int j = 0; j < col; j ++) {
            int count = 0;
            for (int i = 0; i < row; i ++)
                if (A[i][j] > 0) 
                    count ++;
            if (row - count > count)
                count = row - count;
            ans += count * base;
            base >>= 1;
        }
        return ans;
    }
}