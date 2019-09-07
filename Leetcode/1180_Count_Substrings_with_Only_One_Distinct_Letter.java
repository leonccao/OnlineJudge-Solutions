class Solution {
    public int countLetters(String S) {
        int len = 0, ans = 0;
        char ch = '$';
        for (char cur : S.toCharArray()) {
            if (cur == ch) {
                len ++;
            } else {
                ans += (1 + len) * len / 2;
                ch = cur;
                len = 1;
            }
        }
        if (len > 0) {
            ans += (1 + len) * len / 2;
        }
        return ans;
    }
}