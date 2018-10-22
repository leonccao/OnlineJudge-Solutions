class Solution {
    public void DFS(int[] nums, int now, List<List<Integer>> result, List<Integer> answer) {
        if (now == nums.length) return;
        
        answer.add(nums[now]);
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        for (int i = 0; i < answer.size(); i ++)
            tmp.add(answer.get(i));
        result.add(tmp);
        
        DFS(nums, now + 1, result, answer);
        answer.remove(answer.size() - 1);
        DFS(nums, now + 1, result, answer);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<Integer> answer = new LinkedList<Integer>();
        result.add(answer);
        DFS(nums, 0, result, answer);
        return result;
    }
}