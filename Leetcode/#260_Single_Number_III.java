class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums)
            x ^= num;
        x = Integer.lowestOneBit(x);
        int[] ans = new int[2];
        for (int num : nums)
            if ((num & x) != 0)
                ans[0] ^= num;
            else ans[1] ^= num;
        return ans;
    }
}