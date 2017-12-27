class Solution {
    public int trailingZeroes(int n) {
        int num5 = 0;
        int tmp = n;
        while (tmp >= 5) {
            tmp /= 5;
            num5 ++;
        }
        
        tmp = 1;
        int result = 0;
        for (int i = 0; i < num5; i ++) {
            tmp *= 5;
            result += n / tmp;
        }
        return result;
    }
}