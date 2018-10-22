class Solution {
    
    private int calcBits(long num) {
        return Long.valueOf(num).toString().length();
    }
    
    private int[] calcDigits(long num) {
        char[] chs = Long.valueOf(num).toString().toCharArray();
        int[] digits = new int[10];
        for (char ch : chs) {
            digits[ch - '0'] ++;
        }
        return digits;
    }
    
    public boolean reorderedPowerOf2(int N) {
        long base = 1;
        while (calcBits(N) != calcBits(base))
            base *= 2;
        
        int[] digits0 = calcDigits(N);
        OUTER_LOOP:
        while (calcBits(base) == calcBits(N)) {
            int[] digits1 = calcDigits(base);
            for (int i = 0; i < 10; i ++)
                if (digits1[i] != digits0[i]) {
                    base *= 2;
                    continue OUTER_LOOP;
                }
            return true;
        }
        return false;
    }
}