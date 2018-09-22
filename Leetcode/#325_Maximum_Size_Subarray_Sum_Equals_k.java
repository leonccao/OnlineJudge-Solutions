/*
### Corner cases
1. Array element could be negative or zero
2. Target could be negative or zero

### Solution
1. HashMap
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs

### Test cases


*/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                ans = Math.max(ans, i - map.get(sum - k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return ans;
    }
}