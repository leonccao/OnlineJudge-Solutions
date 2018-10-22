class Solution {
    public int titleToNumber(String s) {
        StringBuilder sb = new StringBuilder(s);
        int result = 0;
        for (int i = 0; i < sb.length(); i ++)
            result = result * 26 + sb.charAt(i) - 'A' + 1;
        return result;
    }
}