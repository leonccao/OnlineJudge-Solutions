class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer, Integer>[] rec = new HashMap[A.length];
        for (int i = 0; i < A.length; i ++)
            rec[i] = new HashMap<Integer, Integer>();
            
        int ans = 0;
        for (int i = 0; i < A.length; i ++)
            for (int j = i + 1; j < A.length; j ++) {
                long d = (long)A[j] - A[i];
                if (d <= Integer.MIN_VALUE || 
                    d > Integer.MAX_VALUE) continue;
                int diff = (int)d;
                int cnt = rec[j].getOrDefault(diff, 0);
                int tmp = rec[i].getOrDefault(diff, 0);
                ans += tmp;
                cnt += tmp;
                rec[j].put(diff, cnt + 1);
            }
        
        return ans;
    }
}