class Solution {
public:
    int divide(int dividend, int divisor) {
        if (!divisor) return INT_MAX;
        long long divid = dividend;
        long long divis = divisor;
            
        bool sign = false;
        if (divid < 0) {
            sign = !sign;
            divid = - divid;
        }
        if (divis < 0) {
            sign = !sign;
            divis = - divis;
        }
        
        const long long one = 1;
        long long c, k, result = 0;
        while (divid >= divis) {
            bool finished = false;
            for (c = divis, k = 0; divid >= c; c <<= 1, k ++) {
                if (divid - c < divis) {
                    result = result + (one << k);
                    finished = true;
                    break;
                }
            }
            if (finished) break;
            divid -= c >> 1;
            result += 1 << (k - 1);
        }
        if (sign) result = - result;
        if (result > INT_MAX)
            return INT_MAX;
        return result;
    }
};