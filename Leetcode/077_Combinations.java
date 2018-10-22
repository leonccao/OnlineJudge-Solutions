class Solution {
    public void DFS(int n, int now, int left, List<List<Integer>> result, List<Integer> answer) {
        if (left == 0) {
            LinkedList<Integer> tmp = new LinkedList<Integer>();
            for (int i = 0; i < answer.size(); i ++)
                tmp.add(answer.get(i));
            result.add(tmp);
        }
        if (left == 0 || now > n) return;
        if (n - now + 1 < left) return;
        
        answer.add(now);
        DFS(n, now + 1, left - 1, result, answer);
        answer.remove(answer.size() - 1);
        DFS(n, now + 1, left, result, answer);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<Integer> answer = new LinkedList<Integer>();
        if (k > n) return result;
        if (k == 0) {
            result.add(answer);
            return result;
        }
        DFS(n, 1, k, result, answer);
        return result;
    }
}