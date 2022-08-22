class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                cnt++;
            }
        }
        int minRec = cnt;
        
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                cnt++;
            }
            if (blocks.charAt(i - k) == 'W') {
                cnt--;
            }
            minRec = Math.min(minRec, cnt);
        }
        return minRec;
    }
}