class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int count = 1;
        for (int i = 1; i <= n; i ++) {
            if (i > 10) break;
            int base = 9, tmp = 9;
            for (int j = 1; j < i; j ++) {
                tmp *= base;
                base -= 1;
            }
            count += tmp;
        }
        return count;
    }
}