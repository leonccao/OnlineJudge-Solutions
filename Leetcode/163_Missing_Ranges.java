class Solution {
    
    public String translate(int a, int b) {
        if (a == b) return "" + a;
        return "" + a + "->" + b;
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        LinkedList<String> ans = new LinkedList<>();
        
        if (nums.length == 0) {
            ans.offer(translate(lower, upper));
            return ans;
        }
        
        if (lower < nums[0]) {
            ans.offer(translate(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            if ((long)nums[i] >= (long)nums[i + 1] - 1) continue;
            ans.offer(translate(nums[i] + 1, nums[i + 1] - 1));
        }
        if (nums[nums.length - 1] < upper) {
            ans.offer(translate(nums[nums.length - 1] + 1, upper));
        }
        return ans;
    }
}