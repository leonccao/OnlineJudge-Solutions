class Solution {
    public boolean isNumber(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        // delete all prefix and suffix zeros
        while (sb.length() > 0 && sb.charAt(0) == ' ')
            sb.deleteCharAt(0);
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ')
            sb.deleteCharAt(sb.length() - 1);
        if (sb.length() < 1) return false;
        
        // check if invalid characters exist
        int np = 0, ne = 0, ns = 0;
        for (int i = 0; i < sb.length(); i ++) {
            char ch = sb.charAt(i);
            if (ch < '0' || ch > '9') {
                if (ch == 'e') ne ++;
                else if (ch == '.') np ++;
                else if (ch =='+' || ch =='-') ns ++;
                else return false;
            }
        }

        if (np > 1 || ne > 1 || ns > 2) return false;
        if (np == 0 && ne == 0) {
            if (validSign(sb.toString()))
                return true;
            return false;
        }
        if (np == 1 && ne == 0) {
            int pos = sb.indexOf(".");
            if (validSignEmpty(sb.substring(0, pos)) && 
                validEmpty(sb.substring(pos + 1, sb.length())) &&
                sb.length() != 1 && 
                !sb.toString().equals("+.") && 
                !sb.toString().equals("-."))
                return true;
            return false;
        }
        if (np == 0 && ne == 1) {
            int pos = sb.indexOf("e");
            if (validSign(sb.substring(0, pos)) && validSign(sb.substring(pos + 1, sb.length())))
                return true;
            return false;
        }
        if (np == 1 && ne == 1) {
            int posp = sb.indexOf(".");
            int pose = sb.indexOf("e");
            if (posp > pose) return false;
            if (isNumber(sb.substring(0, pose)) &&
                validSign(sb.substring(pose + 1, sb.length())))
                return true;
            return false;
        }
        return false;
    }
    
    public boolean validSignEmpty(String s) {
        if (s == null || s.length() < 1) return true;
        for (int i = 1; i < s.length(); i ++)
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        return true;
    }
    
    
    public boolean validSign(String s) {
        if (s == null || s.length() < 1) return false;
        if (s.equals("+") || s.equals("-")) return false;
        for (int i = 1; i < s.length(); i ++)
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        return true;
    }
    
    public boolean validEmpty(String s) {
        if (s == null || s.length() < 1) return true;
        for (int i = 0; i < s.length(); i ++)
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        return true;
    }
    
}

class Solution {
    public boolean isNumber(String s) {
        
        s = s.trim();
        
        boolean e = false, point = false, num = false, numAfterE = false;
        
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = true;
                numAfterE = true;
            } else if (ch == 'e') {
                if (e || !num) return false;
                numAfterE = false;
                e = true;
            } else if (ch == '.') {
                if (point || e) return false;
                point = true;
            } else if (ch == '+' || ch == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        return num & numAfterE;
    }
}