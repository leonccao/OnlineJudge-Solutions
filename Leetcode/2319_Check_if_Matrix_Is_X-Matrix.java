class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j || i + j + 1 == m) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
                
            }
        }
        return true;
    }
}