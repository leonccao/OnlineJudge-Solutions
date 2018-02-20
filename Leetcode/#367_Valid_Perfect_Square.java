class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num + 1;
        while (l < r - 1) {
            long mid = (l + r) / 2;
            long sq = mid * mid;
            if (sq == num) return true;
            if (sq > num) r = mid;
            else l = mid + 1;
        }
        if (l * l == num) return true;
        return false;
    }
}