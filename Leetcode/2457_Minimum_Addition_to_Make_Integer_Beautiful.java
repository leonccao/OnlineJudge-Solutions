class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long origin = n, base = 1;
        
        while (getDigitsSum(n) > target) {
            long cur = n / base % 10;
            if (cur > 0) {
                n += (10 - cur) * base;
            }
            base *= 10;
        }
        return n - origin;
    }
    
    private int getDigitsSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}