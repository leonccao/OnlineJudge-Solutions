class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length, n = mat[0].length;
        int combs = 1 << n;
        
        int[] mats = new int[m];
        for (int i = 0; i < m; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                cur = cur * 2 + mat[i][j];
            }
            mats[i] = cur;
        }
        
        int max = 0;
        for (int pat = 1; pat <= combs; pat++) {
            int cur = pat;
            int cnt = 0;
            while (cur > 0) {
                cnt += cur % 2;
                cur /= 2;
            }
            if (cnt != cols) {
                continue;
            }
            
            cnt = 0;
            for (int i = 0; i < m; i++) {
                if ((pat | mats[i]) == pat) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}