class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0) return A;
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < A.length && A[i] % 2 == 0) i ++;
            while (j >= 0       && A[j] % 2 != 0) j --;
            if (i < j) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}