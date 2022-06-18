class Solution {
    
    int[] locate, cookies;
    int result, c, k;
    
    public int distributeCookies(int[] cookies, int k) {
        c = cookies.length;
        this.k = k;
        this.cookies = cookies;
        result = Integer.MAX_VALUE;
        locate = new int[c];
        dfs(0);
        return result;
    }
    
    private void dfs(int cur) {
        if (cur >= c) {
            int[] sum = new int[k];
            int temp = 0;
            for (int i = 0; i < c; i++) {
                sum[locate[i]] += cookies[i];
                temp = Math.max(temp, sum[locate[i]]);
            }
            result = Math.min(result, temp);
            return;
        }
        
        for (int i = 0; i < k; i ++) {
            locate[cur] = i;
            dfs(cur + 1);
        }
    }
}