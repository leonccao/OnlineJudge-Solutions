class Solution {
    
    final static int MOD = 1000000000 + 7;
    
    public int idealArrays(int n, int maxValue) {
        List<Integer> primes = getPrimes(maxValue);
        
        long[][] c = getCombinations(n);
        
        long result = 0;
        for (int num = 1; num <= maxValue; num++) {
            int cur = num;
            long resultNum = 1;
            
            for (int prime : primes) {
                if (prime > cur) {
                    break;
                }
                int cnt = 0;
                while (cur % prime == 0) {
                    cnt++;
                    cur /= prime;
                }
                if (cnt > 0) {
                    resultNum *= c[n + cnt - 1][cnt];
                    resultNum %= MOD;
                }
            }
            
            result += resultNum;
            result %= MOD;
        }
        return (int)result;
    }
    
    private List<Integer> getPrimes(int maxValue) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= maxValue; num++) {
            boolean isPrime = true;
            for (int prime : primes) {
                // If prime is already larger than sqrt
                // Then no way prime is a factor
                if (prime > Math.sqrt(num)) {
                    break;
                }
                if (num % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }
        return primes;
    }
    
    private long[][] getCombinations(int n) {
        long[][] c = new long[n + 14][14];
        c[0][0] = 1;
        for (int i = 1; i < n + 14; i++) {
            if (i < 14) {
                c[i][i] = 1;
            }
            c[i][0] = 1;
            for (int j = 1; j < 14 && j < i; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                c[i][j] %= MOD;
            }
        }
        return c;
    }
}