class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        int pos = -1;
        for (int i = 0; i < S.length(); i ++) {
            if (S.charAt(i) == C) {
                pos = i;
                ans[i] = 0;
            } else if (pos == -1) {
                ans[i] = Integer.MAX_VALUE;
            } else {
                ans[i] = i - pos;
            }
        }
        
        pos = -1;
        for (int i = S.length() - 1; i >= 0; i --) {
            if (S.charAt(i) == C) {
                pos = i;
            } else if (pos != -1) {
                ans[i] = Math.min(ans[i], pos - i);
            }
        }
        return ans;
    }
}