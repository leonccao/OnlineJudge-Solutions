class Solution {
    public String greatestLetter(String s) {
        for (char ch = 'Z'; ch >= 'A'; ch--) {
            char cl = Character.toLowerCase(ch);
            if (s.indexOf(ch) > -1 && s.indexOf(cl) > -1) {
                return "" + ch;
            }
        }
        return "";
    }
}