class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        
        long divd = dividend, divs = divisor, l = 0, r;
        if ((divd > 0 && divs > 0) || (divd < 0 && divs < 0))
            r = Math.abs(divd) + 1;
        else r = -Math.abs(divd) - 1;
        
        while (Math.abs(r - l) > 1) {
            long mid = (l + r) / 2;
            if (Math.abs(mid * divs) == Math.abs(divd)) return (int)mid;
            else if (Math.abs(mid * divs) < Math.abs(divd)) l = mid;
            else r = mid;
        }
        return (int)l;
    }
}