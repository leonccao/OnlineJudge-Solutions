class Solution {
    public int maxProfit(int[] prices) {
        int cool = 0;
        int buy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            int tmpCool = Math.max(cool, sell);
            sell = buy + prices[i];
            buy = Math.max(cool - prices[i], buy);
            cool = tmpCool;
        }
        return Math.max(cool, sell);
    }
}