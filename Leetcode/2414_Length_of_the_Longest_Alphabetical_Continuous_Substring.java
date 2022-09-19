class Solution {
    public int longestContinuousSubstring(String s) {
        int result = 1;
        char last = 'z';
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch - 'a' - 1 == last - 'a') {
                count++;
            } else {
                count = 1;
            }
            last = ch;
            result = Math.max(result, count);
        }
        return result;
    }
}