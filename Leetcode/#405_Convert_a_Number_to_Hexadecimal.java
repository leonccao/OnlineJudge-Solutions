class Solution {
    public String toHex(int num) {
        long input = num >= 0 ? num : ((long)1 << 32) + num;
        System.out.println(1 << 32);
        if (input == 0) return "0";
        StringBuilder result = new StringBuilder();
        while (input > 0) {
            long tmp = input % 16;
            input /= 16;
            char ch = tmp > 9 ? (char)('a' + tmp - 10) : (char)('0' + tmp);
            result.append(ch);
        }
        return result.reverse().toString();
    }
}