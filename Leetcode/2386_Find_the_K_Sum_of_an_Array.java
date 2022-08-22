class Solution {
    public long kSum(int[] nums, int k) {
    
        long maxSum = 0;
        for (int num : nums) {
            maxSum += Math.max(0, num);
        }
        
        int[] abs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            abs[i] = Math.abs(nums[i]);
        }
        Arrays.sort(abs);
        
        long lastPop = maxSum;
        
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>(
            (a, b) -> Long.compare(b[0], a[0])
        );
        pq.offer(new long[]{maxSum - abs[0], (long)0});
        
        for (int i = 1; i < k; i++) {
            long[] cur = pq.poll();
            lastPop = cur[0];
            int curIndex = (int)cur[1];
            if (curIndex < nums.length - 1) {
                pq.offer(new long[]{lastPop - abs[curIndex + 1], curIndex + 1});
                pq.offer(new long[]{lastPop + abs[curIndex] - abs[curIndex + 1], curIndex + 1});
            }
        }
        return lastPop;
    }
}