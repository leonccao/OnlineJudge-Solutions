class Solution {
public:
    double myPow(double x, int n) {
        if (!n) return 1;
        double tmp = 1;
        if (n % 2 == 1) tmp = x;
        else if (n % 2 == -1) tmp = 1 / x;
        double pow = myPow(x, n / 2);
        tmp = tmp * pow * pow;
        return tmp;
    }
};