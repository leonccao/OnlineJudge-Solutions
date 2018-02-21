class Solution {
    public int findNthDigit(int n) {
        long sumBits = 9, nowBits = 9;
        int base = 0, left = n, bits = 1;
        while (sumBits < n) {
            nowBits *= 10;
            left = (int)(n - sumBits);
            sumBits += nowBits * (++ bits);
            base = (base + 1) * 10 - 1;
        }
        Integer num = (left + bits - 1) / bits  + base;
        int numBit = (left - 1) % bits;
        return num.toString().charAt(numBit) - '0';
    }
}