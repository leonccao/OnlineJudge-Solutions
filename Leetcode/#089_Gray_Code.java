class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new LinkedList<Integer>();
        ans.add(0);
        int pos = 0, base = 1;
        for (int round = 0; round < n; round ++ ) {
            for (int i = 0; i < base; i ++) {
                ans.add(base | ans.get(base - i - 1));
            }
            base <<= 1;
        }
        return ans;
    }
}