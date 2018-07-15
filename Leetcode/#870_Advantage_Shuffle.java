class Solution {
    
    private class Num {
        private int val, index;
        public Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    private class NumComparator implements Comparator<Num> {
        public int compare(Num a, Num b) {
            return a.val - b.val;
        }
    }
    
    public int[] advantageCount(int[] A, int[] B) {
        Num[] a = new Num[A.length];
        Num[] b = new Num[B.length];
        for (int i = 0; i < A.length; i ++) {
            a[i] = new Num(A[i], i);
            b[i] = new Num(B[i], i);
        }
        
        Arrays.sort(a, new NumComparator());
        Arrays.sort(b, new NumComparator());
        
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);
        boolean[] f = new boolean[a.length];
        Arrays.fill(f, false);
        
        int pos = 0;
        for (int i = 0; i < b.length; i ++) {
            while (pos < a.length && a[pos].val <= b[i].val)
                pos ++;
            if (pos == a.length) break;
            ans[b[i].index] = a[pos].val;
            f[a[pos].index] = true;
            pos ++;
        }
        
        pos = 0;
        for (int i = 0; i < a.length; i ++) {
            if (ans[i] == -1) {
                while (f[pos] == true) pos ++;
                ans[i] = A[pos];
                f[pos] = true;
                pos ++;
            }
        }
        return ans;
    }
}