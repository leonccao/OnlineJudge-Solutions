class Solution {
    
    private boolean isPalindrome(String s) { // <-
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        if (s.equals(t)) return true;
        return false;
    }
    
    public boolean validPalindrome(String s) {
        // palindrome without deleting
        if (isPalindrome(s)) return true;
        
        // delete one character
        int i = 0, j = s.length() - 1;
        while (s.charAt(i) == s.charAt(j)) {
            i ++;
            j --;
        }
        if (isPalindrome(s.substring(i, j)))
            return true;
        if (isPalindrome(s.substring(i + 1, j + 1)))
            return true;
        return false;
    }
}