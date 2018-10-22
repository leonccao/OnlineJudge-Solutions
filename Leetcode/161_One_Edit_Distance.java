/*
### Corner cases
1. Same -> false
2. Length difference larger than 1
3. S and t contains the same one character

### Solution
1. Match from left to right and from right to left, check if the sum is larger or equal to the longer length minus 1
    - Time complexity: O(n)
    - Space complexity: O(1)

*/
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        
        int ml = 0, mr = 0;
        int limit = Math.min(s.length(), t.length());
        while (ml < limit && s.charAt(ml) == t.charAt(ml)) ml ++;
        while (mr < limit && s.charAt(s.length() - mr - 1) == t.charAt(t.length() - mr - 1)) mr ++;
        
        if (s.length() > t.length()) {
            if (ml + mr >= s.length() - 1)
                return true;
        } else {
            if (ml + mr >= t.length() - 1)
                return true;
        }
        return false;
    }
}