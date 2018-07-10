class Solution {
    
    private boolean check(int sample) {
        int sqrt = (int)Math.sqrt(sample);
        for (int div = 2; div <= sqrt; div ++)
            if (sample % div == 0)
                return false;
        return true;
    }
    
    private int findPP(int len, int N) {
        int half = (len + 1) / 2;
        int limit = (int)Math.pow(10, half);
        int base = (int)Math.pow(10, half - 1);
        int bias = base;
        while (base < limit) {
            if ((base / bias) % 2 == 0)
                base += bias;
            StringBuilder left  = new StringBuilder(Integer.valueOf(base).toString());
            StringBuilder right = new StringBuilder(Integer.valueOf(base).toString());
            if (right.length() > 0) {
                if (len % 2 != 0)
                right.deleteCharAt(right.length() - 1);
                right = right.reverse();
                left.append(right);
            }
            int sample = Integer.valueOf(left.toString());
            if (sample >= N && check(sample)) return sample;
            base ++;
        }
        return -1;
    }
    
    public int primePalindrome(int N) {
        if (N == 1) return 2;
        if (N == 2) return 2;
        int len = 0;
        int tmp = N;
        while (tmp > 0) {
            len ++;
            tmp /= 10;
        }
        while (true) {
            int rtn = findPP(len, N);
            if (rtn != -1) return rtn;
            len ++;
        }
    }
}