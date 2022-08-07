class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                for (int k = j + 1; k < n; k ++) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        result ++;
                    }
                }
            }
        }
        return result;
    }
}