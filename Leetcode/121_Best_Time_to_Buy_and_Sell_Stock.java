class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 1000000000;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i ++) {
            maxProfit = Math.max(maxProfit, 
                                 prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxs = 0, minp = Integer.MAX_VALUE / 2;
        for (int price : prices) {
            maxs = Math.max(maxs, price - minp);
            minp = Math.min(minp, price);
        }
        return maxs;
    }
}

// new 
class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE, sold = 0;
        for (int price : prices) {
            sold = Math.max(sold, hold + price);
            hold = Math.max(hold, - price);
        }
        return sold;
    }
}