class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<Integer>();
        int len = S.length();
        if (len == 0 || S.equals("")) return ans;
        
        for (int i = 1; i <= len / 2; i ++) {
            if (S.charAt(0) == '0' && i > 1) break;
            if (i > 10) break;
            for (int j = 1; j <= len / 2; j ++) {
                if (S.charAt(i) == '0' && j > 1) break;
                if (j > 10) break;
                
                String si = S.substring(0, i);
                Long nl = Long.parseLong(si);
                if (nl > Integer.MAX_VALUE) break;
                int ni = Integer.parseInt(si);
                String sj = S.substring(i, i + j);
                nl = Long.parseLong(sj);
                if (nl > Integer.MAX_VALUE) break;
                int nj = Integer.parseInt(sj);
                ans.clear();
                ans.add(ni);
                ans.add(nj);
                
                //System.out.print(ni + " " + nj);
                
                int last = ni;
                int next = nj;
                int pos = i + j;
                if (pos == len) break;
                while (pos < len) {
                    int cur = last + next;
                    
                    //System.out.println(cur);
                    
                    String cs = Integer.valueOf(cur).toString();
                    if (!S.startsWith(cs, pos)) break;
                    ans.add(cur);
                    last = next;
                    next = cur;
                    pos += cs.length();
                }
                if (pos == len) return ans;
            }
        }
        ans.clear();
        return ans;
    }
}