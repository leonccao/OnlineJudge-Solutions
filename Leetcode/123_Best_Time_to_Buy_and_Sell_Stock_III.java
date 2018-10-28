class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int price : prices) {
            release2    = Math.max(release2, hold2 + price);
            hold2       = Math.max(hold2, release1 - price);
            release1    = Math.max(release1, hold1 + price);
            hold1       = Math.max(hold1, - price);
        }
        return release2;
    }
}

// new 
class Solution {
    public int maxProfit(int[] prices) {
        int hold1, sold1, hold2, sold2;
        hold1 = hold2 = Integer.MIN_VALUE;
        sold1 = sold2 = 0;
        for (int price : prices) {
            sold2 = Math.max(sold2, hold2 + price);
            hold2 = Math.max(hold2, sold1 - price);
            sold1 = Math.max(sold1, hold1 + price);
            hold1 = Math.max(hold1,       - price);
        }
        return sold2;
    }
}