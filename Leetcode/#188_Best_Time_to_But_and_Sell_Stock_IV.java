class Solution {
    public int maxProfit(int K, int[] prices) {
        int[] e = new int[prices.length];
        K = Math.min(K, prices.length / 2);
        int maxe, maxs, maxp;
        for (int k = 0; k < K; k ++) {
            maxe = 0;
            maxs = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i ++) {
                maxp = maxs;
                maxs = Math.max(maxs, maxe - prices[i]);
                maxe = Math.max(maxe, e[i]);
                e[i] = maxp + prices[i];
            }
        }
        int answer = 0;
        for (int i = 0; i < prices.length; i ++)
            answer = Math.max(answer, e[i]);
        return answer;
    }
}