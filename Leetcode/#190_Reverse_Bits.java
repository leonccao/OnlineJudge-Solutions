public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0, tmp = 0;
        for (int i = 0; i < 32; i ++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
            System.out.println(i + " " + tmp);
        }
        return result;
    }
}