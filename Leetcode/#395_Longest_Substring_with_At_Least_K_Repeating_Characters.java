class Solution {
    public int longestSubstring(String s, int k) {
        return find(s, 0, s.length(), k);
    }
    
    private int find(String s, int start, int end, int k) {
        if (start == end) return 0;
        int[] letters = new int[26];
        for (int i = start; i < end; i ++) {
            int index = s.charAt(i) - 'a';
            letters[index] ++;
        }
        
        boolean valid = true;
        for (int i = 0; i < 26; i ++)
            if (letters[i] > 0 && letters[i] < k) {
                valid = false;
                break;
            }
        if (valid) return end - start;
        
        int rtn = 0, pos = start - 1;
        for (int i = start; i < end; i ++)
            if (letters[s.charAt(i) - 'a'] < k) {
                if (i - pos - 1 > rtn)
                    rtn = Math.max(rtn, find(s, pos + 1, i, k));
                pos = i;
                System.out.println("pos: " + pos);
            }
        if (end - pos - 1 > rtn)
            rtn = Math.max(rtn, find(s, pos + 1, end, k));
        
        return rtn;
    }
}