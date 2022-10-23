import java.math.BigInteger;

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            for (int j = i; j < nums.length; j++) {
                gcd = BigInteger.valueOf(gcd).gcd(BigInteger.valueOf(nums[j])).intValue();
                if (gcd == k) {
                    result++;
                }
            }
        }
        return result;
    }
}