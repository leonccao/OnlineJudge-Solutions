class Solution {
    
    final static int T = 26;
    
    public int leastInterval(char[] tasks, int n) {
        
        int[] left = new int[T];
        int[] ava  = new int[T];
        for (char ch : tasks) {
            int tmp = ch - 'A';
            left[tmp] ++;
        }
        for (int i = 0; i < T; i ++)
            if (left[i] > 0)
                ava[i] = 0;
        
        int clock = 0, cnt = 0;
        while (cnt < tasks.length) {
            int pos = -1;
            int leftp = Integer.MIN_VALUE;
            int cool = 0;
            // find the one with largest storage left
            for (int i = 0; i < T; i ++) {
                if (left[i] == 0) continue;
                if (ava[i] <= clock && left[i] > leftp) {
                    pos = i;
                    leftp = left[i];
                }
                cool = Math.max(cool, ava[i] - clock);
            }
            
            // CPU working
            if (pos != -1) {
                left[pos] --;
                ava[pos] += n + 1;   
                clock ++;
                cnt ++;
            // CPU idle
            } else clock += cool;
        }
        
        return clock;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxn = Integer.MIN_VALUE;
        int[] cnt = new int[26];
        for (char ch : tasks) {
            maxn = Math.max(maxn, ++ cnt[ch - 'A']);
        }
        int ans = (maxn - 1) * (n + 1);
        for (int i = 0; i < 26; i ++) {
            if (cnt[i] == maxn)
                ans ++;
        }
        return Math.max(ans, tasks.length);
    }
}