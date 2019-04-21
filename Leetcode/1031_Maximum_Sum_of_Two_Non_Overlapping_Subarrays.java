class Solution {
    public int find(int[] A, int l, int r, int len) {
        int max = Integer.MIN_VALUE;
        if (r - l < len) return max;
        int tmp = 0;
        for (int i = l; i < r; i ++) {
            tmp += A[i];
            if (i - l + 1 > len)
                tmp -= A[i - len];
            if (i - l + 1 >= len)
                max = Math.max(max, tmp);
        }
        return max;
    }
    
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i ++) {
            int tmp = find(A, 0, i, L) + find(A, i, A.length, M);
            max = Math.max(max, tmp);
            tmp = find(A, 0, i, M) + find(A, i + 1, A.length, L);
            max = Math.max(max, tmp);
        }
        return max;
    }
}