class Solution {
    public boolean isPalindrome(String s) {
        if (s == "") return true;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i ++) 
            if (sb.charAt(i) >= 'a' &&
               sb.charAt(i) <= 'z')
                sb.setCharAt(i, (char)(sb.charAt(i) - 32));
        // System.out.println(sb.toString());
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            while (i < j && 
                   (sb.charAt(i) < 'A' || 
                    sb.charAt(i) > 'Z') &&
                  (sb.charAt(i) < '0' || 
                    sb.charAt(i) > '9')) i ++;
            while (i < j && 
                   (sb.charAt(j) < 'A' || 
                    sb.charAt(j) > 'Z') &&
                  (sb.charAt(j) < '0' || 
                    sb.charAt(j) > '9')) j --;
            if (sb.charAt(i) != sb.charAt(j)) return false;
            i ++;
            j --;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch))
                sb.append(ch);
        }
        String a = sb.toString();
        String b = sb.reverse().toString();
        if (!a.equals(b)) return false;
        return true;
    }
}