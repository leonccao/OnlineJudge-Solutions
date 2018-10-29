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

// new

class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0, a = 0, b = 0;
        for (int num : nums) x ^= num;
        x = Integer.lowestOneBit(x);
        for (int num : nums)
            if ((x & num) == 0) a ^= num;
            else b ^= num;
        return new int[]{a, b};
    }
}