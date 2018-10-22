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

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        
        int l = 0, r = matrix.length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] <= target) l = mid;
            else r = mid;
        }
        int row = l;
        l = 0; r = matrix[0].length;
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] <= target) l = mid;
            else r = mid;
        }
        if (matrix[row][l] == target) return true;
        return false;
    }
}