class Solution {
    public void DFS(int cur, String s, List<List<String>> result, List<String> path, boolean[][] p) {
        if (cur == s.length()) {
            List<String> copy = new ArrayList<String>();
            copy.addAll(path);
            result.add(copy);
            return;
        }
        for (int i = cur; i < s.length(); i ++) {
            if (!p[cur][i]) continue;
            path.add(s.substring(cur, i + 1));
            DFS(i + 1, s, result, path, p);
            path.remove(path.size() - 1);
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        if (s.equals("") || s.length() == 0) {
            result.add(path);
            return result;
        }
        
        boolean[][] p = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i ++)
            p[i][i] = true;
        for (int i = 1; i < s.length(); i ++)
            if (s.charAt(i - 1) == s.charAt(i))
                p[i - 1][i] = true;
        for (int i = s.length() - 3; i > -1; i --)
            for (int j = i + 2; j < s.length(); j ++)
                if (p[i + 1][j - 1])
                    if (s.charAt(i) == s.charAt(j))
                        p[i][j] = true;
    
        DFS(0, s, result, path, p);
        return result;
    }
}