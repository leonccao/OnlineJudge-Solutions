class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            int tmp = (~a&b&c) | (a&~b&~c);
            b = (~a&~b&c) | (~a&b&~c);
            a = tmp;
        }
        return b;
    }
}

// new 
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            int tmp = (~a & b & c) | (a & ~b & ~c);
            b = (~a & ~b & c) | (~a & b & ~c);
            a = tmp;
        }
        return b;
    }
}