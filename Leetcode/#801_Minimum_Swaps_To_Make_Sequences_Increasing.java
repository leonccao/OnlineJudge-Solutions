class Solution {
    public int minSwap(int[] A, int[] B) {
        int maxn = 12345678;
        int[] c = new int[A.length];
        int[] u = new int[A.length];
        c[0] = 1;
        u[0] = 0;
        for (int i = 1; i < A.length; i ++) {
            u[i] = c[i] = maxn;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                u[i] = Math.min(u[i], u[i - 1]);
                c[i] = Math.min(c[i], c[i - 1] + 1);
            }
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                u[i] = Math.min(u[i], c[i - 1]);
                c[i] = Math.min(c[i], u[i - 1] + 1);
            }
        }
        return Math.min(u[A.length - 1], c[A.length - 1]);
    }
}