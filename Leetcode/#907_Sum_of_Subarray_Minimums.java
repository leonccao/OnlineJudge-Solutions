class Solution {
    final static int MOD = 1000000000 + 7;
    
    public int sumSubarrayMins(int[] A) {
        int[] left  = new int[A.length];
        int[] right = new int[A.length];
        for (int i = 0; i < A.length; i ++)
            left[i] = right[i] = i;
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < A.length; i ++) {
            int pos = left[i];
            while (!stack.isEmpty() && A[i] < A[stack.peek()])
                pos = left[stack.pop()];
            stack.push(i);
            left[i] = pos;
        }
        stack.clear();
        for (int i = A.length - 1; i >= 0; i --) {
            int pos = right[i];
            while (!stack.isEmpty() && A[i] <= A[stack.peek()])
                pos = right[stack.pop()];
            stack.push(i);
            right[i] = pos;
        }
        
        int ans = 0;
        for (int i = 0; i < A.length; i ++) {
            int tmp = (int)(((long)A[i] * (long)(i - left[i] + 1) * (long)(right[i] - i + 1)) % MOD);
            ans = (ans + tmp) % MOD;
            
        }
        return ans;
    }
}