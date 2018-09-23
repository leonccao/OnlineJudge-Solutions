class Solution {
    
    final static char[] FINAL = {'0', '1', '8'};
    final static char[] LEFT  = {'0', '1', '6', '8', '9'};
    final static char[] RIGHT = {'0', '1', '9', '8', '6'};
    
    private void builder(StringBuilder front, StringBuilder back, int target, List<String> ans) {
        // nearly finished
        if (target / 2 <= front.length()) {
            if (target == front.length() + back.length()) {
                ans.add(front.append(back.reverse()).toString());
                front.delete(front.length() - back.length(), front.length());
                back.reverse();
                return;
            }
            for (char ch : FINAL) {
                front.append(ch);
                builder(front, back, target, ans);
                front.deleteCharAt(front.length() - 1);
            }
            return;
        }
        int base = front.length() > 0 ? 0 : 1;
        for (int i = base; i < LEFT.length; i ++) {
            front.append(LEFT[i]);
            back.append(RIGHT[i]);
            builder(front, back, target, ans);
            front.deleteCharAt(front.length() - 1);
            back.deleteCharAt(back.length() - 1);
        }
    }
    
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<String>();
        builder(new StringBuilder(), new StringBuilder(), n, ans);
        return ans;
    }
}