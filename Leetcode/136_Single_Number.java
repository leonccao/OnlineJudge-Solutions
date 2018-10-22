class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int tmp : nums)
            result ^= tmp;
        return result;
    }
}