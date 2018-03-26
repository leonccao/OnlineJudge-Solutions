/*
s: 3:33 PM
e: 3:44 PM
*/
class Solution {
    public int numDistinct(String s, String t) {
        if (t.equals("") || t.length() == 0)
            return 1;
        if (s.equals("") || s.length() == 0)
            return 0;
        
        int[][] f = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i ++)
            if (s.charAt(i) == t.charAt(0))
                f[i][0] = 1;
        int result = f[0][t.length() - 1];
        for (int i = 1; i < s.length(); i ++) {
            for (int j = 1; j < t.length(); j ++) {
                if (j > i) break;
                if (s.charAt(i) != t.charAt(j))
                    continue;
                for (int k = 0; k < i; k ++)
                    f[i][j] += f[k][j - 1];
            }
            result += f[i][t.length() - 1];
        }
        return result;
    }
}