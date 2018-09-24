class Solution {
    private void build(int index, List<Integer> select, int[] nums, Set<Integer> trash, List<List<Integer>> ans) {
        if (index == nums.length) {
            if (select.size() < 2) return;
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(select);
            ans.add(tmp);
            return;
        }
        
        int cur = nums[index];
        boolean thrown = false;
        if ((select.isEmpty() || cur >= select.get(select.size() - 1)) && !trash.contains(cur)) {
            select.add(cur);
            build(index + 1, select, nums, new HashSet<Integer>(), ans);
            select.remove(select.size() - 1);
            // throw it in trash
            trash.add(cur);
            thrown = true;
        }
        build(index + 1, select, nums, trash, ans);
        if (thrown) trash.remove(cur);
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        build(0, new ArrayList<Integer>(), nums, new HashSet<Integer>(), ans);
        return ans;
    }
}