class Solution {
    public int minDeletionSize(String[] A) {
        int ans = 0;
        OUTER_LOOP:
        for (int i = 0; i < A[0].length(); i ++) {
            for (int j = 1; j < A.length; j ++)
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    ans ++;
                    continue OUTER_LOOP;
                }
        }
        return ans;
    }
}