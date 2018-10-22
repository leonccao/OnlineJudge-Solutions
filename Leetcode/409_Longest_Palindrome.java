class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[52];
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (ch > 'Z')
                letters[ch - 'a'] ++;
            else letters[ch - 'A' + 26] ++;
        }
        boolean odd = false;
        int result = 0;
        for (int i = 0; i < 52; i ++) {
            if (letters[i] % 2 == 1)
                odd = true;
            while (letters[i] > 1) {
                letters[i] -= 2;
                result += 2;
            }
        }
        if (odd == true) result ++;
        return result;
    }
}