class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];
        int[] count = new int[33];
        int index = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int[] curBits = getBits(nums[i]);
            for (int j = 0; j < 33; j++) {
                count[j] += curBits[j];
            }
            int[] tailBits = getBits(nums[index]);
            while (index > i && enough(count, tailBits)) {
                for (int j = 0; j < 33; j++) {
                    count[j] -= tailBits[j];
                }
                tailBits = getBits(nums[--index]);
            }
            ans[i] = index - i + 1;
        }
        return ans;
    }
    
    private int[] getBits(int num) {
        int[] bits = new int[33];
        int index = 0;
        while (num > 0) {
            bits[index++] = num % 2;
            num /= 2;
        }
        return bits;
    }
    
    private boolean enough(int[] allBits, int[] curBits) {
        for (int i = 0; i < 33; i++) {
            if (curBits[i] > 0 && allBits[i] < 2) {
                return false;
            }
        }
        return true;
    }
}