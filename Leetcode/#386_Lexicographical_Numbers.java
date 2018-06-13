class Solution {
    private void helper(int prefix, int n, List<Integer> list) {
        if (prefix <= n) list.add(prefix);
        if (prefix >= n) return;
        
        for (int i = 0; i < 10; i ++)
            helper(prefix * 10 + i, n, list);
    }
    
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i ++)
            helper(i, n, list);
        return list;
    }
}