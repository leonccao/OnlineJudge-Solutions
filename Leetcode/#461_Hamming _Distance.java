class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int k = 1; k < Integer.MAX_VALUE && k > 0; k <<= 1)
            if (((x & k) ^ (y & k)) != 0)
                ans ++;
        return ans;
    }
}