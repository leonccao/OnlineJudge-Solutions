class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        search(0, 0, target, "", num, ans);
        return ans;
    }
    
    private void search(int index, long sum, int target, String prefix, String s, List<String> ans) {
        if (index == s.length()) {
            if (sum == target)
                ans.add(prefix);
            return;
        }
        
        long num = 0;
        for (int i = index; i < s.length(); i ++) {
            num = num * 10 + s.charAt(i) - '0';
            if (index == 0)
                search(i + 1, num, target, "" + num, s, ans);
            else {
                search(i + 1, sum + num, target, prefix + "+" + num, s, ans);
                search(i + 1, sum - num, target, prefix + "-" + num, s, ans);
            }
            if (num == 0) break;
        }
    }
}