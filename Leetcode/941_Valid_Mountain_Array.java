class Solution {
    public boolean validMountainArray(int[] A) {
        boolean up = false, down = false;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] == A[i - 1]) return false;
            if (A[i] > A[i - 1]) {
                if (down) return false;
                up = true;
            } else {
                if (!up) return false;
                down = true;
            }
        }   
        return down;
    }
}