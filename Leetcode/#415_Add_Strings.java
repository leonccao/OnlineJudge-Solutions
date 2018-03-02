class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder a = new StringBuilder(num1);
        a = a.reverse();
        StringBuilder b = new StringBuilder(num2);
        b = b.reverse();
        int len = Math.max(a.length(), b.length());
        
        StringBuilder c = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; i ++) {
            int na = i < a.length() ? a.charAt(i) - '0' : 0;
            int nb = i < b.length() ? b.charAt(i) - '0' : 0;
            int tmp = na + nb + carry;
            c.append(tmp % 10);
            carry = tmp / 10;
        }
        if (carry > 0)
            c.append(1);
        return c.reverse().toString();
    }
}