class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int tmp : nums)
            result ^= tmp;
        return result;
    }
}

// new 
class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums)
            x ^= num;
        return x;
    }
}