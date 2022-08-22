class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] cnt = new int[s.length() + 1];
        for (int[] shift : shifts) {
            int flag = shift[2] == 1 ? 1 : -1;
            cnt[shift[0]] = (cnt[shift[0]] + flag) % 26;
            cnt[shift[1] + 1] = (cnt[shift[1] + 1] - flag + 26) % 26;
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = (sum + cnt[i] + 26) % 26;
            char cur = (char)((s.charAt(i) - 'a' + sum) % 26 + 'a');
            sb.append(cur);
        }
        return sb.toString();
    }
}