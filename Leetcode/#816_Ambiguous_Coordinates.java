class Solution {
    public List<String> build(String s) {
        List<String> ans = new LinkedList<String>();
        if (s.length() == 1 && s.charAt(0) == '0')
            ans.add("0");
        if (s.charAt(0) != '0') {
            ans.add(s);
        }
        if (s.charAt(s.length() - 1) != '0' && s.length() > 1) {
            StringBuilder sb = new StringBuilder(s);
            sb.insert(1, '.');
            ans.add(sb.toString());
            if (s.charAt(0) != '0') {
                for (int i = 2; i < s.length(); i ++) {
                    sb.deleteCharAt(i - 1);
                    sb.insert(i, '.');
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }
    
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new LinkedList<String>();
        for (int i = 2; i < S.length() - 1; i ++) {
            String s = S.substring(1, i);
            String t = S.substring(i, S.length() - 1);
            
            List<String> as = build(s);
            if (as.size() == 0) continue;
            List<String> at = build(t);
            if (at.size() == 0) continue;
            
            for (String w1 : as)
                for (String w2 : at)
                    ans.add("(" + w1 + ", " + w2 + ")");
        }
        return ans;
    }
}