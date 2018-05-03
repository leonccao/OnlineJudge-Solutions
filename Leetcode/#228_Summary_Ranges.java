class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<String>();
        if (nums.length == 0) return ans;
        
        int last = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            if (i < nums.length - 1 && 
                nums[i] + 1 == nums[i + 1])
                    continue;
            if (last == nums[i])
                ans.add(((Integer)last).toString());
            else ans.add(last + "->" + nums[i]);
            if (i < nums.length - 1)
                last = nums[i + 1];
        }
        return ans;
    }
}