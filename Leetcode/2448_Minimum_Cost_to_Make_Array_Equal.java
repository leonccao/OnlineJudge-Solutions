class Solution {
    public long minCost(int[] nums, int[] cost) {
        int[][] a = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            a[i][0] = nums[i];
            a[i][1] = cost[i];
        }
        Arrays.sort(a, (p, q) -> p[0] - q[0]);
        
        long[] sumLeft = new long[nums.length];
        long[] sumRight = new long[nums.length];
        long[] costLeft = new long[nums.length];
        long[] costRight = new long[nums.length];
        sumLeft[0] = costLeft[0] = sumRight[nums.length - 1] = costRight[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            sumLeft[i] = sumLeft[i - 1] + (long)a[i - 1][0] * a[i - 1][1];
            costLeft[i] = costLeft[i - 1] + a[i - 1][1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            sumRight[i] = sumRight[i + 1] + (long)a[i + 1][0] * a[i + 1][1];
            costRight[i] = costRight[i + 1] + a[i + 1][1];
        }
        
        long result = Long.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            long curRight = sumRight[i] - costRight[i] * a[i][0];
            long curLeft = costLeft[i] * a[i][0] - sumLeft[i];
            result = Math.min(result, curLeft + curRight);
        }
        return result;
    }
}