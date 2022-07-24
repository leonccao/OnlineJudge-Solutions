class Solution {
    public boolean canChange(String start, String target) {
        StringBuilder sb = new StringBuilder();
        int[] si = new int[start.length()];
        int index = 0;
        for (int i = 0; i < start.length(); i++) {
            char ch = start.charAt(i);
            if (ch == '_') {
                continue;
            }
            sb.append(ch);
            si[index++] = i;
        }
        
        int index2 = 0;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (ch == '_') { 
                continue;
            }
            
            if (index2 >= sb.length()) {
                return false;
            }
            if (sb.charAt(index2) != ch) {
                return false;
            }
            if (ch == 'L') {
                if (si[index2] < i) {
                    return false;
                }
            } else {
                if (si[index2] > i) {
                    return false;
                }
            }
            index2++;
        }
        if (index != index2) {
            return false;
        }
        return true;
    }
}