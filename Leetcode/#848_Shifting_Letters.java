class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        
        int[] sum = new int[shifts.length];
        sum[0] = shifts[0] % 26;
        for (int i = 1; i < shifts.length; i ++)
            sum[i] = (sum[i - 1] + shifts[i]) % 26;
        
        StringBuilder s = new StringBuilder(S);
        for (int i = 0; i < shifts.length; i ++) {
            int shift = (i == 0) ? sum[shifts.length - 1] : sum[shifts.length - 1] - sum[i - 1] + 26;
            char ch = s.charAt(i);
            ch = (char)('a'+ (ch - 'a' + shift) % 26);
            s.setCharAt(i, ch);
        }
        return s.toString();
    }
}