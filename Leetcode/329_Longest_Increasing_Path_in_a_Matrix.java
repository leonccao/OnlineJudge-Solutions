class Solution {
    
    final static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    class Num {
        int x;
        int y;
        int val;
        Num(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length    == 0) return 0;
        if (matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        Num[] nums = new Num[row * col];
        for (int i = 0; i < row; i ++)
            for (int j = 0; j < col; j ++)
                nums[i * col + j] = new Num(i, j, matrix[i][j]);
        Arrays.sort(nums, new Comparator<Num>() {
            public int compare(Num a, Num b) {
                return a.val - b.val;
            } 
        });
        
        int[][] f = new int[row][col];
        int ans = 0;
        for (Num num : nums) {
            for (int[] mv : move) {
                int x = num.x + mv[0];
                int y = num.y + mv[1];
                if (x < 0 || x == row) continue;
                if (y < 0 || y == col) continue;
                if (matrix[x][y] >= num.val) continue;
                f[num.x][num.y] = Math.max(f[num.x][num.y], f[x][y] + 1);
            }
            ans = Math.max(ans, f[num.x][num.y]);
        }
        return ans + 1;
    }
}

// new 
class Solution {
    
    final static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        Map<String, Integer> visited = new HashMap<>();
        
        int ans = 0;
        for (int i = 0; i < matrix.length; i ++)
            for (int j = 0; j < matrix[0].length; j ++)
                ans = Math.max(ans, helper(i, j, matrix, visited));
        return ans;
    }
    
    private int helper(int x, int y, int[][] matrix, Map<String, Integer> visited) {
        String cur = x + " " + y;
        if (visited.containsKey(cur)) 
            return visited.get(cur);
        
        int result = 1;
        for (int[] mv : move) {
            int i = x + mv[0], j = y + mv[1];
            if (i < 0 || i == matrix.length)    continue;
            if (j < 0 || j == matrix[0].length) continue;
            if (matrix[i][j] >= matrix[x][y])   continue;
            result = Math.max(result, helper(i, j, matrix, visited) + 1);
        }
        visited.put(cur, result);
        return result;
    }
}