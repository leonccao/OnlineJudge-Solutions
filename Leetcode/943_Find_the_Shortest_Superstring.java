class Solution {
    
    int min = Integer.MAX_VALUE;
    String ans = "";
    int[][] into;
    boolean[] visited;
    int[] maxShort;
    
    private int merge(String a, String b) {
        int lim = Math.min(a.length(), b.length());
        for (int len = lim; len > 0; len --) {
            if (b.startsWith(a.substring(a.length() - len)))
                return len;
        }
        return 0;
    }
    
    private void dfs(int cnt, int last, StringBuilder sb, String[] A) {
        int tmp = sb.length();
        for (int i = 0; i < A.length; i ++) {
            if (visited[i]) continue;
            tmp += A[i].length() - maxShort[i];
        }
        if (tmp >= min) return;
        
        if (cnt == A.length) {
            if (sb.length() >= min) return;
            min = sb.length();
            ans = sb.toString();
            return;
        }
        
        int len = sb.length();
        for (int i = 0; i < A.length; i ++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmp = last > -1 ? into[last][i] : 0;
            sb.append(A[i].substring(tmp));
            dfs(cnt + 1, i, sb, A);            
            sb.setLength(len);
            visited[i] = false;
        }
    }
    
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        into = new int[n][n];
        maxShort = new int[n];
        for (int i = 0; i < A.length; i ++) 
        for (int j = 0; j < A.length; j ++) {
            if (i == j) continue;
            into[i][j] = merge(A[i], A[j]);
            maxShort[j] = Math.max(maxShort[j], into[i][j]);
        }
        
        visited = new boolean[A.length];
        dfs(0, -1, new StringBuilder(), A);
        return ans;
    }
}