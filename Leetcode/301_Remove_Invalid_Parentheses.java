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

class Solution {
    
    private class Match {
        public int rm;
        public Set<String> rec;
        
        public Match() {
            rm = Integer.MAX_VALUE / 2;
            rec = new HashSet<String>();
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> rtn = new LinkedList<String>();
        if (s.length() == 0) {
            rtn.add("");
            return rtn;
        }
        
        int len = s.length();
        
        Match[][] match = new Match[len][len];
        
        // when the length is 1
        for (int i = 0; i < len; i ++) {
            match[i][i] = new Match();
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                match[i][i].rm = 1;
                match[i][i].rec.add("");
            } else {
                match[i][i].rm = 0;
                match[i][i].rec.add("" + s.charAt(i));
            }
        }
        
        // when the length is > 1
        for (int i = len - 1; i >= 0 ; i --)
            for (int j = i + 1; j < len; j ++) {
                match[i][j] = new Match();
                if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                    if (j - i > 1) {
                        match[i][j].rm = match[i + 1][j - 1].rm;
                        for (String st : match[i + 1][j - 1].rec) {
                            match[i][j].rec.add("(" + st + ")");
                        }
                    } else {
                        match[i][j].rm = 0;
                        match[i][j].rec.add("()");
                    }
                }
                for (int k = i; k < j; k ++) {
                    if (match[i][k].rm + match[k + 1][j].rm < match[i][j].rm) {
                        match[i][j].rm = match[i][k].rm + match[k + 1][j].rm;
                        match[i][j].rec.clear();
                    }
                    if (match[i][k].rm + match[k + 1][j].rm == match[i][j].rm) {
                        for (String tl : match[i][k].rec)
                            for (String tr : match[k + 1][j].rec) {
                                match[i][j].rec.add(tl + tr);
                            }
                    }
                }
            }
        
        for (String st : match[0][len - 1].rec)
            rtn.add(st);
        return rtn;
    }
}

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char ch : s.toCharArray())
            if (ch == '(') l ++;
            else if (ch == ')') {
                if (l > 0) l --;
                else r ++;
            }
        Set<String> ans = new HashSet<String>();
        removeHelper(0, l, r, 0, s, new StringBuilder(), ans);
        List<String> rtn = new ArrayList<String>();
        rtn.addAll(ans);
        return rtn;
    }
    
    private void removeHelper(int index, int l, int r, int open, String s, StringBuilder prefix, Set<String> ans) {
        if (l < 0 || r < 0 || open < 0) return;
        
        if (index == s.length()) {
            if (l + r == 0)
                ans.add(prefix.toString());
            return;
        }
        
        char ch = s.charAt(index);
        if (ch == '(') {
            removeHelper(index + 1, l - 1, r, open, s, prefix, ans);
            removeHelper(index + 1, l, r, open + 1, s, prefix.append(ch), ans);
        } else if (ch == ')') {
            removeHelper(index + 1, l, r - 1, open, s, prefix, ans);
            removeHelper(index + 1, l, r, open - 1, s, prefix.append(ch), ans);
        } else removeHelper(index + 1, l, r, open, s, prefix.append(ch), ans);
        
        prefix.setLength(prefix.length() - 1);
    }
}