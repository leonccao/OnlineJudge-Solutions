class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int len = A.length;
        int ans = 0;
        for (int hb = -len; hb < len; hb ++)
            for (int vb = -len; vb < len; vb ++) {
                int collect = 0;
                for (int i = 0; i < len; i ++)
                    for (int j = 0; j < len; j ++)
                        if (A[i][j] == 1)
                            if (i + hb >= 0 && i + hb < len)
                                if (j + vb >= 0 && j + vb < len)
                                    if (A[i][j] == B[i + hb][j + vb])
                                        collect ++;
                ans = Math.max(ans, collect);
            }
        return ans;
    }
}