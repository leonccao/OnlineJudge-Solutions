class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = 1;
        if ((n & 1) != 0)
            result = n > 0 ? x : 1.0 / x;
        double tmp = myPow(x, n / 2);
        return result * tmp * tmp;
    }
}