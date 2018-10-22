class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        
        Map<Long, Long> bucket = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i ++) {
            long num = nums[i];
            long fall = (num - Integer.MIN_VALUE) / ((long)t + 1);
            // System.out.println(fall);
            
            if (bucket.containsKey(fall)
               || (bucket.containsKey(fall - 1) && num - bucket.get(fall - 1) <= t)
               || (bucket.containsKey(fall + 1) && bucket.get(fall + 1) - num <= t))
                return true;
            
            bucket.put(fall, num);
            
            if (bucket.size() > k) {
                long oldNum = nums[i - k];
                long oldFall = (oldNum - Integer.MIN_VALUE) / ((long)t + 1);
                bucket.remove(oldFall);
            }
        }
        return false;
    }
}