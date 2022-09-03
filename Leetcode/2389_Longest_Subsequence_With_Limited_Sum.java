class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0, sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (sum + nums[j] <= queries[i]) {
                    sum += nums[j];
                    cnt++;
                } else {
                    break;
                }
            }
            result[i] = cnt;
        }
        return result;
    }
}