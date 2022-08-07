class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 ) {
                if (nums[i] > 0) {
                cnt++;
                }
            } else {
                if (nums[i] != nums[i - 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}