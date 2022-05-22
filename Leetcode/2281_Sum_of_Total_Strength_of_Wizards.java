class Solution {
    final static long MOD = 1000000000 + 7;
    
    public int totalStrength(int[] strength) {
        int len = strength.length;
        long[] preSumL = new long[len];
        long[] preSumR = new long[len];
        long[] preMulSumL = new long[len];
        long[] preMulSumR = new long[len]; 
        
        // Calculate prefix sum 
        // From left to right
        preSumL[0] = strength[0];
        preMulSumL[0] = strength[0];
        for (int i = 1; i < len; i++) {
            preSumL[i] = (preSumL[i - 1] + strength[i]) % MOD;
            preMulSumL[i] = (preMulSumL[i - 1] + (long)(i + 1) * strength[i]) % MOD;
        }
        // From right to left
        preSumR[len - 1] = strength[len - 1];
        preMulSumR[len - 1] = strength[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            preSumR[i] = (preSumR[i + 1] + strength[i]) % MOD;
            preMulSumR[i] = (preMulSumR[i + 1] + (long)(len - i) * strength[i]) % MOD;
        }
        
        long result = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i <= len; i++) {
            while (stack.size() > 0 && (i == len || strength[i] <= strength[stack.peek()])) {
                int pivot = stack.pop();
                
                int left = stack.size() > 0 ? stack.peek() + 1 : 0;
                long preSumLeft = left > 0 ? preSumL[left - 1] : 0;
                long preMulSumLeft = left > 0 ? preMulSumL[left - 1] : 0;
                long leftSum = pivot > left ? (preMulSumL[pivot - 1] - preMulSumLeft - (preSumL[pivot - 1] - preSumLeft + MOD) * left % MOD + MOD * 2) % MOD : 0;
                
                int right = i - 1;
                long preSumRight = right < len - 1 ?  preSumR[right + 1] : 0;
                long preMulSumRight = right < len - 1 ? preMulSumR[right + 1] : 0;
                long rightSum = (preMulSumR[pivot] - preMulSumRight - (preSumR[pivot] - preSumRight + MOD) * (len - right - 1) % MOD + MOD * 2) % MOD;
                
                int leftCnt = pivot - left + 1;
                int rightCnt = right - pivot + 1;
                result = (result + (leftSum * rightCnt + rightSum * leftCnt) % MOD * strength[pivot] % MOD) % MOD;
            }
            stack.push(i);
        }
        return (int)result;
    }
}