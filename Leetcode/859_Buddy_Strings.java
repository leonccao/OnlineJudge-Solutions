class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int diff = 0, pos1 = -1, pos2 = -1;
        
        int[] num = new int[26];
        for (int i = 0; i < A.length(); i ++) {
            num[A.charAt(i) - 'a'] ++;
            if (A.charAt(i) != B.charAt(i)) {
                diff ++;
                if (pos1 == -1) pos1 = i;
                else pos2 = i;
            }
        }
        if (diff == 0) {
            for (int i = 0; i < 26; i ++)
                if (num[i] > 1) return true;
            return false;
        }
        if (diff != 2) return false;
        if (A.charAt(pos1) != B.charAt(pos2)) return false;
        if (A.charAt(pos2) != B.charAt(pos1)) return false;
        return true;
    }
}