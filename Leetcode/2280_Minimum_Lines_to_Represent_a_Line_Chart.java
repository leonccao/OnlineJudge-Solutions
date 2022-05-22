class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        }
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int count = 1;
        for (int i = 2; i < stockPrices.length; i++) {
            long x0 = stockPrices[i - 2][0], y0 = stockPrices[i - 2][1];
            long x1 = stockPrices[i - 1][0], y1 = stockPrices[i - 1][1];
            long x2 = stockPrices[i][0], y2 = stockPrices[i][1];
            
            long left = (y1 - y0) * (x2 - x1);
            long right = (y2 - y1) * (x1 - x0);
            if (left != right) {
                count++;
            }
        }
        return count;
    }
}