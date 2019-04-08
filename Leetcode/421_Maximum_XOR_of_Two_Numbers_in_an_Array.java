class Solution {
    public int findMaximumXOR(int[] nums) {
        int bits = 0, max = 0;
        for (int i = 1 << 30; i > 0; i >>= 1) {
            // add higher bits into set
            bits |= i;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & bits);
            }
            
            // check maximum
            int cur = max | i;
            for (int num : set) {
                if (set.contains(cur ^ num)) {
                    max = cur;
                    break;
                }
            }
        }
        return max;
    }
}