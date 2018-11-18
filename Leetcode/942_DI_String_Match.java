class Solution {
    
    public int[] diStringMatch(String S) {
        int[] ans = new int[S.length() + 1];
        ans[0] = 0;
        int min = 0;
        int n = S.length() + 1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = -n + 1; i < n; i ++)
            set.add(i);
        set.remove(0);
        for (int i = 0; i < S.length(); i ++) {
            if (S.charAt(i) == 'I') {
                int tmp = set.ceiling(ans[i]);
                set.remove(tmp);
                ans[i + 1] = tmp;
            } else {
                int tmp = set.floor(ans[i]);
                set.remove(tmp);
                ans[i + 1] = tmp;
                min = Math.min(min, tmp);
            }
        }
        int tmp = 0 - min;
        for (int i = 0; i < ans.length; i ++)
            ans[i] += tmp;
        return ans;
    }
}