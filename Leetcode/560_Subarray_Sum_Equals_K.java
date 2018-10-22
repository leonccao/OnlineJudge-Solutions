/*
### Corner cases
1. 

### Solution
1. HashMap(prefixSum, times)

### Bugs
1. Add zero into map if subarray starts from the first element
2. `Map.getOrDefault(Object key, V defaultValue)`

### Test case

*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int tmp = sum - k;
            if (map.containsKey(tmp)) ans += map.get(tmp);
            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return ans;
    }
}