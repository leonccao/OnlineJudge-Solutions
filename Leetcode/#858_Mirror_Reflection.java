class Solution {
    private int findLCM(int p, int q) {
        int tmp = findGCD(p, q);
        return p * q / tmp;
    }
    
    private int findGCD(int p, int q) {
        if (q == 0) return p;
        return findGCD(q, p % q);
    }
    
    public int mirrorReflection(int p, int q) {
        if (q == 0) return 0;
        if (q == p) return 1;
        if (q * 2 == p) return 2;
        
        int lcm = findLCM(p, q);
        int tmp = lcm / q;
        int tmp2 = lcm / p;
        if (tmp % 2 == 0) return 2;
        if (tmp % 2 != 0) {
            if (tmp2 % 2 == 0) return 0;
            return 1;
        }
        return -1;
    }
}