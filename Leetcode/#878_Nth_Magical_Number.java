class Solution {
    final static int MOD = 1000000007;
    
    private int GCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    private int LCM(int a, int b) {
        return a / GCD(a, b) * b;
    }
    
    public int nthMagicalNumber(int N, int A, int B) {
        
        if (A % B == 0) return (int)((long)N * B % MOD);
        if (B % A == 0) return (int)((long)N * A % MOD);
        
        int lcm = LCM(A, B);
        int count = lcm / A + lcm / B - 1;
        System.out.println(count);
        long ans = (long)N / count * lcm;
        int left = N % count;
        
        long a = A, b = B, last = 0;
        while (left > 0) {
            while (a == last) a += A;
            while (b == last) b += B;
            if (a < b) {
                last = a;
                a += A;
            } else {
                last = b;
                b += B;
            }
            left --;
        }
        return (int)((ans + last) % 1000000007);
    }
}