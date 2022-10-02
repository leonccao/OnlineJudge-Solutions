class Solution {
    public int minimizeXor(int num1, int num2) {
        int cntNum2 = 0;
        while (num2 > 0) {
            cntNum2 += num2 % 2;
            num2 /= 2;
        }
        int tmpNum1 = num1, cntNum1 = 0;
        while (tmpNum1 > 0) {
            cntNum1 += tmpNum1 % 2;
            tmpNum1 /= 2;
        }
        
        if (cntNum2 == cntNum1) {
            return num1;
        }
        
        
        int result = 0;
        if (cntNum2 < cntNum1) {
            while (cntNum2 > 0) {
                int bit = Integer.highestOneBit(num1);
                result |= bit;
                num1 ^= bit;
                cntNum2--;
            }
            return result;
        }
        int bit = 1;
        
        result = num1;
        while (cntNum2 > cntNum1) {
            if ((bit & num1) == 0) {
                result |= bit;
                cntNum2--;
            }
            bit <<= 1;
        }
        return result;
    }
}