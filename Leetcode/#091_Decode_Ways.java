class Solution {
    public int numDecodings(String s) {
        if (s.equals("") || s.length() == 0)
            return 0;
        
        if (s.charAt(0) == '0')
            return 0;
        int[] f = new int[s.length()];
        f[0] = 1;
        if (s.length() == 1) return f[0];
        f[1] = s.charAt(1) == '0' ? 0 : 1;
        if (Integer.parseInt(s.substring(0, 2)) < 27)
            f[1] ++;
        
        for (int i = 2; i < s.length(); i ++) {
            if (s.charAt(i) != '0') 
                f[i] = f[i - 1];
            else f[i] = 0;
            if (s.charAt(i - 1) != '0' &&
                Integer.parseInt(s.substring(i - 1, i + 1)) < 27)
                f[i] += f[i - 2];
        }
        return f[s.length() - 1];
    }
}