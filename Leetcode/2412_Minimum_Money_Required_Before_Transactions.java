class Solution {
    public long minimumMoney(int[][] transactions) {
        long sumOfPos = 0;
        for (int[] tran : transactions) {
            long less = (long)tran[0] - tran[1];
            if (less > 0) {
                sumOfPos += less;
            }
        }
        long result = 0;
        for (int[] tran : transactions) {
            long less = (long)tran[0] - tran[1];
            long adjustSum = less > 0 ? sumOfPos - less : sumOfPos;
            result = Math.max(result, adjustSum + tran[0]);
        }
        return result;
    }
}