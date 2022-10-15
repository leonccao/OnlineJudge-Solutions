class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int[] count = new int[n];
        int maxLen = 0, maxId = 0;
        for (int i = 0; i < logs.length; i++) {
            int len = i > 0 ? logs[i][1] - logs[i - 1][1] : logs[i][1];
            if (len > maxLen ||
                (len == maxLen && logs[i][0] < maxId)) {
                maxLen = len;
                maxId = logs[i][0];
            }
        }
        return maxId;
    }
}