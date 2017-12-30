class Solution {
    public boolean isHappy(int n) {
        for (int i = 0; i < 10000; i ++) {
            int tmpRes = 0, tmp = 0;
            while (n > 0) {
                tmp = n % 10;
                tmpRes += tmp * tmp;
                n /= 10;
            }
            if (tmpRes == 1) return true;
            n = tmpRes;
        }
        return false;
    }
}