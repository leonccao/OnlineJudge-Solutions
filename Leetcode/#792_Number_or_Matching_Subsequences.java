class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for (String str : words)
            if (match(S, str))
                result ++;
        return result;
    }
    
    public boolean match(String S, String str) {
        int i = 0, j = 0;
        while (i < S.length() && j < str.length()) {
            if (S.charAt(i) == str.charAt(j)) {
                i ++; j ++;
            } else i ++;
        }
        return j == str.length();
    }
}