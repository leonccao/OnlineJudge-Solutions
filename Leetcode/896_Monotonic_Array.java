class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length == 0) return false;
        int sum = 0;
        for (int i = 1; i < A.length; i ++) {
            int tmp = 0;
            if (A[i] >  A[i - 1]) tmp =  1;
            if (A[i] <  A[i - 1]) tmp = -1;
            if (tmp * sum < 0) return false;
            sum += tmp;
        }
        return true;
    }
}

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; i ++) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
            if (!inc && !dec) return false;
        }
        return true;
    }
}