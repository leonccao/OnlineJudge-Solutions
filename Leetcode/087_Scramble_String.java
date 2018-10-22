class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals("") || s1.length() == 0)
            return false;
        if (s1.length() == 1 && !s1.equals(s2))
            return false;
        if (s1.equals(s2)) return true;
        
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s1.length(); i ++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (map1.containsKey(c1))
                map1.put(c1, map1.get(c1) + 1);
            else map1.put(c1, 1);
            if (map2.containsKey(c2))
                map2.put(c2, map2.get(c2) + 1);
            else map2.put(c2, 1);
        }
        for (int i = 0; i < s1.length(); i ++) {
            char ch = s1.charAt(i);
            if (map1.get(ch) != map2.get(ch))
                return false;
        }
        
        for (int i = 1; i < s1.length(); i ++) {
            // if swap
            if (isScramble(s1.substring(0, i), 
                           s2.substring(s2.length() - i, s2.length())) &&
                isScramble(s1.substring(i, s1.length()), 
                           s2.substring(0, s2.length() - i)))
                return true;
            // if not swap
            if (isScramble(s1.substring(0, i), 
                           s2.substring(0, i)) &&
                isScramble(s1.substring(i, s1.length()), 
                           s2.substring(i, s2.length())))
                return true;
        }
        return false;
    }
}