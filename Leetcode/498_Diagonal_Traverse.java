/*
### Corner cases
1. Input is empty
2. Only one row or column

### Solution 
1. Enumerate (m + n)
    - Time complexity: O((m + n) ^ 2)
    - Space complexity: O(1)
2. Iteratr through
    - Time complexity: O(mn)
    - Space complexity: O(1)

*/
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        
        int cnt = 0;
        int[] ans = new int[m * n];
        boolean reverse = true;
        for (int k = 0; k < m + n - 1; k ++) {
            for (int i = 0; i < m; i ++) {
                int row = reverse ? m - i - 1 : i;
                if (k - row < 0 || k - row >= n) continue;
                ans[cnt ++] = matrix[row][k - row];
            }
            reverse = !reverse;
        }
        return ans;
    }
}

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] ans = new int[m * n];
        int i = 0, j = 0;
        for (int idx = 0; idx < ans.length; idx ++) {
            ans[idx] = matrix[i][j];
            if ((i + j) % 2 == 0) { // go upwards
                if (j == n - 1) i ++;
                else if (i == 0) j ++;
                else { i --; j ++; }
            } else { // go downwards
                if (i == m - 1) j ++;
                else if (j == 0) i ++;
                else {i ++; j --; }
            }
        }
        return ans;
    }
}