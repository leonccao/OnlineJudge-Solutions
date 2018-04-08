class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i ++)
            sum[i] = sum[i - 1] + A[i];
        double[][] avg = new double[A.length][A.length];
        for (int i = 0; i < A.length; i ++) {
            avg[0][i] = sum[i] * 1.0 / (i + 1);
            for (int j = 1; j <= i; j ++)
                avg[j][i] = (sum[i] - sum[j - 1]) * 1.0 / (i - j + 1);
        }
        
        double[][] res = new double[A.length][A.length];
        for (int i = 0; i < A.length; i ++) {
            res[i][0] = avg[0][i];
            for (int k = 1; k < K; k ++) {
                for (int j = 0; j < i; j ++) {
                    double tmp = res[j][k - 1] + avg[j + 1][i];
                    if (tmp > res[i][k])
                        res[i][k] = tmp;
                }
            }
        }
        double answer = 0;
        for (int k = 0; k < K; k ++)
            if (res[A.length - 1][k] > answer)
                answer = res[A.length - 1][k];
        return answer;
    }
}