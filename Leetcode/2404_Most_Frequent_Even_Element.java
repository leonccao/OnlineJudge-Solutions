class Solution {
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int result = -1, recCnt = -1, count = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 1) {
                continue;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                count = 1;
            } else {
                count++;
            }
            if (count > recCnt) {
                result = num;
                recCnt = count;
            }
        }
        return result;
    }
}