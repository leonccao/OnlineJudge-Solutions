class Solution {
    public int minMaxGame(int[] nums) {
        int len = nums.length;
        int[] numsPre = Arrays.copyOf(nums, nums.length);
        while (len > 1) {
            len /= 2;
            int[] numsNew = new int[len];
            
            for (int i = 0; i < len; i ++) {
                if (i % 2 == 0) {
                    numsNew[i] = Math.min(numsPre[i * 2], numsPre[i * 2 + 1]);
                } else {
                    numsNew[i] = Math.max(numsPre[i * 2], numsPre[i * 2 + 1]);
                }
            }
            numsPre = numsNew;
        }
        return numsPre[0];
    }
}