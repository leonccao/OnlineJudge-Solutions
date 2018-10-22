class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i ++)
            prime[i] = true;
        for (int i = 1; i < n; i ++) 
            if (prime[i] == true) {
                int tmp = i * 2;
                while (tmp < n) {
                    prime[tmp] = false;
                    tmp += i;
                }
            }
        
        int count = 0;
        for (boolean bool : prime)
            if (bool == true)
                count ++;
        return count;
    }
}