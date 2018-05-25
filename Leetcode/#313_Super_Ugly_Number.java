class Solution {
    class Ugly{
        long val;
        int index;
        int prime;
        Ugly(long val, int index, int prime) {
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n];
        ans[0] = 1;
        PriorityQueue<Ugly> heap = new PriorityQueue<Ugly>(primes.length, new Comparator<Ugly>() {
            public int compare(Ugly a, Ugly b) {
                return (int)(a.val - b.val);
            }
        });
        for (int prime : primes)
            heap.add(new Ugly((long)prime, 0, prime));
        
        
        for (int i = 1; i < n; i ++) {
            long val = heap.peek().val;
            int index = heap.peek().index + 1;
            int prime = heap.poll().prime;
            
            if (ans[i - 1] == val) i --;
            ans[i] = (int)val;
            val = (long)ans[index] * prime;
            heap.add(new Ugly(val, index, prime));
        }
        
        
        return ans[n - 1];
    }
}