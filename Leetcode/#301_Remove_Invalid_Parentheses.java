class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        if (s.length() == 0 || s.equals("")) {
            ans.add("");
            return ans;
        }
        
        int[][] mod = new int[s.length()][s.length()];
        Set<String>[][] rec = (HashSet<String>[][])new HashSet[s.length()][s.length()];
        for (int i = 0; i < s.length(); i ++)
            for (int j = i; j < s.length(); j ++) {
                mod[i][j] = Integer.MAX_VALUE;
                rec[i][j] = new HashSet<String>();
            }
        
        for (int base = 0; base < s.length(); base ++) {
            if (s.charAt(base) == '(' || 
                s.charAt(base) == ')') continue;
            int limit = base;
            while (limit < s.length() && 
                   s.charAt(limit) != '(' && 
                   s.charAt(limit) != ')')
                        limit ++;
            for (int i = base; i < limit; i ++)
                for (int j = i; j < limit; j ++) {
                    mod[i][j] = 0;
                    rec[i][j].add(s.substring(i, j + 1));
                }
        }
        
        for (int start = s.length() - 1; start >= 0; start --)
            for (int end = start; end < s.length(); end ++) {
                // a
                if (mod[start][end] == 0) continue;
                
                // ( or )
                if (start == end) {
                    mod[start][end] = 1;
                    rec[start][end].add("");
                    continue;
                }
                
                // (string)
                if (s.charAt(start) == '(' && 
                    s.charAt(end) == ')') {
                        
                        // ()
                        if (start == end - 1) {
                            mod[start][end] = 0;
                            rec[start][end].add("()");
                            continue;
                        }
                        
                        // (string)
                        int tmp = mod[start + 1][end - 1];
                        if (tmp <= mod[start][end]) {
                            if (tmp < mod[start][end]) {
                                mod[start][end] = tmp;
                                rec[start][end].clear();
                            }
                            for (String st : rec[start + 1][end - 1])
                                rec[start][end].add("(" + st + ")");
                        }
                    }
                
                for (int cut = start; cut < end; cut ++) {
                    int tmp = mod[start][cut] + mod[cut + 1][end];
                    if (tmp <= mod[start][end]) {
                        if (tmp < mod[start][end]) {
                            mod[start][end] = tmp;
                            rec[start][end].clear();
                        }
                        for (String l : rec[start][cut])
                            for (String r : rec[cut + 1][end])
                                rec[start][end].add(l + r);
                    }
                }
            }
        
        ans.addAll(rec[0][s.length() - 1]);
        return ans;
    }
}