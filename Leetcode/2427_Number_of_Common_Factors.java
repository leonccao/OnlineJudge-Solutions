class Solution {
    public int commonFactors(int a, int b) {
        int max = Math.min(a, b);
        int result = 0;
        for (int i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                result++;
            }
        }
        return result;
    }
}