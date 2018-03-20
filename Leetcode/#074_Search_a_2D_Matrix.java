class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            int row = mid / m;
            int col = mid % m;
            // System.out.println(mid);
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] < target)
                l = mid + 1;
            else r = mid;
        }
        // System.out.println(l);
        if (l >= n * m) return false;
        int row = l / m;
        int col = l % m;
        if (matrix[row][col] == target)
            return true;
        else return false;
    }
}