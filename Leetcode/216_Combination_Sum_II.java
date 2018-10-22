class Solution {
    public void search(int leftK, int leftN, List<Integer> path, List<List<Integer>> ans) {
        if (leftK == 0 && leftN == 0) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(path);
            ans.add(tmp);
        }
        if (leftK == 0 || leftN <= 0) return;
        if (leftK * 9 < leftN) return;
        int last = path.size() > 0 ? path.get(path.size() - 1) : 0;
        if (leftK * (last + 1) > leftN) return;
        
        for (int num = last + 1; num < 10; num ++) {
            path.add(num);
            search(leftK - 1, leftN - num, path, ans);
            path.remove(path.size() - 1);
        }   
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        search(k, n, path, ans);
        return ans;
    }
}