class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = (num.length() - 1) / 2;
        
        long last, next;
        for (int a = 1; a <= len; a ++) {
            String sa = num.substring(0, a);
            if (a > 1 && sa.charAt(0) == '0') break;
            
            for (int b = 1; b <= len; b ++) {
                
                if (num.length() - a - b < a || 
                    num.length() - a - b < b)
                        break;
                
                String sb = num.substring(a, a + b);
                if (b > 1 && sb.charAt(0) == '0') break;
                
                last = Long.parseLong(sa);
                next = Long.parseLong(sb);
                
                int base;
                for (base = a + b; base < num.length(); ) {
                    long tmp = last + next;
                    String tmps = Long.valueOf(tmp).toString();
                    
                    if (!num.substring(base, num.length()).startsWith(tmps))
                        break;
                    
                    base += tmps.length();
                    last = next;
                    next = tmp;
                }
                if (base < num.length()) continue;
                return true;
            }
        }
        return false;
    }
}