class Solution {
    
    public String smallestNumber(String pattern) {
        int n = pattern.length() + 1;
        int[] s = new int[n];
        boolean[] v = new boolean[10];
        return dfs(0, pattern, s, v);
    }
    
    public String dfs(int index, String p, int[] s, boolean[] v) {
        if (index > p.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= p.length(); i++) {
                sb.append(s[i]);
            }
            return sb.toString();
        }
        
        
        if (index == 0) {
            for (int i = 1; i < 10; i++) {
                s[index] = i;
                v[i] = true;
                
                String res = dfs(index + 1, p, s, v);
                if (res != null) {
                    return res;
                }
                    
                v[i] = false;
            }
        } else {
            char ch = p.charAt(index - 1);
            int base = s[index - 1];
            if (ch == 'I') {
                for (int i = base + 1; i < 10; i++) {
                    if (v[i]) {
                        continue;
                    }

                    s[index] = i;
                    v[i] = true;

                    String res = dfs(index + 1, p, s, v);
                    if (res != null) {
                        return res;
                    }

                    v[i] = false;
                }
                
            } else {
                for (int i = 1; i < base; i++) {
                    if (v[i]) {
                        continue;
                    }
                    
                    s[index] = i;
                    v[i] = true;

                    String res = dfs(index + 1, p, s, v);
                    if (res != null) {
                        return res;
                    }

                    v[i] = false;
                }
            }
        }
        return null;
    }
}