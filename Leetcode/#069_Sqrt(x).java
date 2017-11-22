class Solution {
    public int mySqrt(int x) {
        final double eps = 0.01;
        double left = 0, right = x + eps;
        while (right - left > eps) {
            double mid = (left + right) / 2;
            // System.out.println(mid);
            if (mid * mid > x)
                right = mid;
            else left = mid;
        }
        int result = (int)Math.floor(left) + 1;
        if ((long)result * result > x)
            return result - 1;
        else return result;
    }
}