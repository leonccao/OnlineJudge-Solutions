class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (double i = 1; i <= Math.sqrt(N); i+= 0.5)
            if (N % i == 0 || N * 1.0 / i % 0.5 == 0) {
                // System.out.println(i);
                double a = i;
                double b = N * 1.0 / a;
                if (a % 1 != 0) {
                    if (a - b / 2 > 0) ans ++;
                } else if (b % 1 != 0) {
                    if (b - a / 2 > 0) ans ++;
                }
                else {
                    if (a % 2 != 0 && b - a / 2 > 0) ans ++;
                    if (b % 2 != 0 && a - b / 2 > 0 && a != b) ans ++;
                }
            }
        return ans;
    }
}