class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] cnt = new long[n];
        for (int i = 0; i < n; i++) {
            cnt[edges[i]] += i;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (cnt[i] > cnt[res]) {
                res = i;
            }
        }
        return res;
    }
}