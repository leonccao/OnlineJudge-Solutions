class Solution {
    public void DFS(int[] nums, int now, List<List<Integer>> result, List<Integer> path, int[] next) {
        if (now == nums.length) {
            LinkedList<Integer> copy = new LinkedList<Integer>();
            copy.addAll(path);
            result.add(copy);
            return;
        }
        path.add(nums[now]);
        DFS(nums, now + 1, result, path, next);
        path.remove(path.size() - 1);
        DFS(nums, next[now], result, path, next);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] next = new int[nums.length];
        int last = nums.length;
        for (int i = nums.length - 1; i >= 0; i --) {
            next[i] = last;
            System.out.println(next[i]);
            if (i > 0 && nums[i] != nums[i - 1])
                last = i;
        }
        
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        DFS(nums, 0, result, path, next);
        return result;
    }
}