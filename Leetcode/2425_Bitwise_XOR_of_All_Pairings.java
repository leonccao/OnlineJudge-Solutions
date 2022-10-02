class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int cnta = nums1.length;
        int cntb = nums2.length;
        int result = 0;
        if (cnta % 2 > 0) {
            for (int num : nums2) {
                result ^= num;
            }
        }
        if (cntb % 2 > 0) {
            for (int num : nums1) {
                result ^= num;
            }
        } 
        return result;
    }
}