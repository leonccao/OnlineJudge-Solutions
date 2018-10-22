class Solution {
    public char findTheDifference(String s, String t) {
        int[] set = new int[26];
        for (int i = 0; i < t.length(); i ++)
            set[t.charAt(i) - 'a'] ++;
        for (int i = 0; i < s.length(); i ++)
            set[s.charAt(i) - 'a'] --;
        for (int i = 0; i < set.length; i ++)
            if (set[i] == 1)
                return (char)('a' + i);
        return ' ';
    }
}