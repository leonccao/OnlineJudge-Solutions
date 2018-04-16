class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int len = nums.length - 1;
        int gap = (int)Math.ceil((double)(max - min) / len);
        if (gap == 0) return 0;
        
        int[] minBkt = new int[len + 1];
        int[] maxBkt = new int[len + 1];
        Arrays.fill(minBkt, Integer.MAX_VALUE);
        Arrays.fill(maxBkt, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int bkt = (num - min) / gap;
            minBkt[bkt] = Math.min(minBkt[bkt], num);
            maxBkt[bkt] = Math.max(maxBkt[bkt], num);
        }
        
        int prev = min;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len; i ++) {
            if (minBkt[i] < Integer.MAX_VALUE)
                ans = Math.max(ans, minBkt[i] - prev);
            if (maxBkt[i] > Integer.MIN_VALUE)
                prev = maxBkt[i];
        }
        ans = Math.max(ans, max - prev);
        return ans;
    }
}