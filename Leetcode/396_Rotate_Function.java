class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0, calc = 0;
        for (int i = 0; i < A.length; i ++) {
            sum += A[i];
            calc +=i * A[i];
        }
        
        int ans = calc;
        for (int i = A.length - 1; i > 0; i --) {
            calc = calc + sum - A.length * A[i];
            ans = Math.max(ans, calc);
        }
        return ans;
    }
}