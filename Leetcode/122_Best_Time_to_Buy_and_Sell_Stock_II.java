class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i ++)
            if (prices[i] > prices[i - 1])
                sum += prices[i] - prices[i - 1];
        return sum;
    }
}

// new 
class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE, sold = 0;
        for (int price : prices) {
            sold = Math.max(sold, hold + price);
            hold = Math.max(hold, sold - price);
        }
        return sold;
    }
}