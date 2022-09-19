class Solution {
    public int minGroups(int[][] intervals) {
        int[] nums = new int[1000002];
        int max = 0;
        for (int[] interval : intervals) {
            nums[interval[0]]++;
            nums[interval[1] + 1]--;
            max = Math.max(interval[0], max);
        }
        int result = 0, tmp = 0;
        for (int i = 1; i <= max; i++) {
            tmp += nums[i];
            result = Math.max(result, tmp);
        }
        return result;
    }
}