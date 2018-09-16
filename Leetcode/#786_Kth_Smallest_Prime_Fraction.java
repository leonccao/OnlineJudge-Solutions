class Solution {
    
    final static double eps = 0.00000001;
    
    private int count(int[] A, double target) {
        int down = 1, cnt = 0;
        for (int up = 0; up < A.length; up ++) {
            while (down < A.length && (double)A[up] / (double)A[down] >= target)
                ++ down;
            cnt += A.length - down;
        }
        return cnt;
    }
    
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int a : A) set.add(a);
        
        double l = 0, r = 1, mid = 0;
        while (r - l >= eps) {
            mid = (l + r) / 2;
            int cnt = count(A, mid);
            if (cnt >= K) r = mid;
            else l = mid;
        }
        
        
        int[] ans = new int[2];
        double max = -1;
        for (int num : A) {
            int upTmp = (int)Math.floor(r * num);
            Integer up;
            if ((up = set.floor(upTmp)) != null) {
                double tmp = (double)up / (double)num;
                if (tmp > max) {
                    max = tmp;
                    ans[0] = up;
                    ans[1] = num;
                }
            }
        }
        
        return ans;
    }
}