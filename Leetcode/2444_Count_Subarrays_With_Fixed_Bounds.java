class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0;
        long result = 0;
        while (left < nums.length) {
            int right = left - 1;
            int minLP = -1, maxLP = -1;
            while (right + 1 < nums.length && 
                  nums[right + 1] >= minK &&
                  nums[right + 1] <= maxK) {
                right++;
            }
            
            if (right < left) {
                left++;
                continue;
            }
            
            for (int i = left; i <= right; i++) {
                if (nums[i] == minK) {
                    minLP = i;
                }
                if (nums[i] == maxK) {
                    maxLP = i;
                }
                if (minLP < 0 || maxLP < 0) {
                    continue;
                }
                
                int pos = Math.min(minLP, maxLP);
                result += pos - left + 1;
            }
            left = right + 1;
        }
        return result;
    }
}