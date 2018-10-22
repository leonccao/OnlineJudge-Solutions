class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean neg = false;
        long num = numerator;
        if (num < 0) { neg = !neg; num = -num; }
        long den = denominator;
        if (den < 0) { neg = !neg; den = -den; }
        StringBuilder answer = new StringBuilder();
        if (neg) answer.append('-');
        
        long intPart = num / den;
        answer.append(intPart);
        long remain = num % den;
        if (remain == 0)
            return answer.toString();
        
        answer.append('.');
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (remain != 0) {
            if (map.containsKey(remain)) {
                int pos = map.get(remain);
                answer.insert(pos, '(');
                answer.append(')');
                return answer.toString();
            }
            map.put(remain, answer.length());
            remain *= 10;
            answer.append(remain / den);
            remain %= den;
        }
        return answer.toString();
    }
}