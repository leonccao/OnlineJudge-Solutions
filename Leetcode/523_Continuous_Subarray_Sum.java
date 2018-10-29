/*
### Corner cases
1. Element maybe zero 
2. Input could be empty
3. K maybe zero or negative

### Solution
1. We store the prefix sum mod k rather than prefix sum. When two prefix sum with the same remainder appears, we got our answer. In other word, if `nums.length > k` the answer is definitely true.

### Bugs
1. 

### Test cases

*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) return false;
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i ++)
                if (nums[i] + nums[i + 1] == 0) return true;
            return false;
        }
        k = k < 0 ? -k : k;
        if (nums.length > k) return true;
        
        int sum = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            int tmp = sum;
            sum = (sum + num) % k;
            if (set.contains(sum)) return true;
            set.add(tmp);
        }
        return false;
    }
}

// new
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        k = k == 0 ? Integer.MAX_VALUE : (k < 0 ? -k : k);
        if (nums.length > k) return true;
        
        Set<Integer> set = new HashSet<>();
        int last = 0;
        for (int num : nums) {
            int cur = (last + num) % k;
            if (set.contains(cur)) return true;
            set.add(last);
            last = cur;
        }
        return false;
    }
}