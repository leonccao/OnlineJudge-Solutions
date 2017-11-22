class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i > -1 || j > -1) {
            int sum = carry;
            if (i > -1) sum += a.charAt(i --) - '0';
            if (j > -1) sum += b.charAt(j --) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}