class Solution {
    public int countDigitOne(int n) {
        if (n < 1) return 0;
        
        int weight = 1;
        int sum = 0;
        int left = n % 10 >= 1 ? 1 : 0;
        for (long base = 10; base <= n && base > 0; base *= 10) {
            int digit = n / (int) base % 10;
            sum += digit * weight;
            if (digit > 1) sum += (int)base;
            if (digit == 1) left += n % (int)base + 1;
            weight = 10 * weight + (int)base;
        }
        return sum + left;
    }
}