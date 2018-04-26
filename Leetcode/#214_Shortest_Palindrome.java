class Solution {
    public String shortestPalindrome(String s) {
        if (s.equals("") || s.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String t = sb.toString();
        
        int[] pre = new int[s.length()];
        pre[0] = -1;
        for (int i = 1, j = -1; i < s.length(); i ++) {
            while (j != -1 && s.charAt(i) != s.charAt(j + 1))
                j = pre[j];
            if (s.charAt(i) == s.charAt(j + 1))
                pre[i] = ++ j;
        }
        
        int j = -1;
        for (int i = 0; i < s.length(); i ++) {
            if (j == s.length() - 1)
                j = pre[j];
            while (j != -1 && t.charAt(i) != s.charAt(j + 1))
                j = pre[j];
            if (t.charAt(i) == s.charAt(j + 1)) ++ j;
        }
        //System.out.println(j);
        return sb.append(s.substring(j + 1, s.length())).toString();
    }
}