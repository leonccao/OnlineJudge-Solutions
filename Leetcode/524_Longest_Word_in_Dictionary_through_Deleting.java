class Solution {
    public String findLongestWord(String s, List<String> d) {
        // check empty string
        if (s == null || s.length() == 0) return "";
        
        // search for ans
        String result = "";
        for (String a : d) {
            if (a.length() < result.length()) {
                continue;
            }
            
            if (check(s, a)) {
                if (a.length() > result.length() || a.compareTo(result) < 0) {
                    result = a;
                }
            }
        }
        
        return result;
    }
    
    private boolean check(String s, String a) {
        int i = 0, j = 0;
        while (i < s.length() && j < a.length()) {
            if (s.charAt(i) == a.charAt(j)) {
                i ++;
                j ++;
            } else {
                i ++;
            }
        }
        if (j >= a.length()) {
            return true;
        }
        return false;
    }
}   