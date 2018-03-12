class Solution {
    public int bestRotation(int[] A) {
        int maxn = 0, k = 0;
        int[] tag = new int[20002];
        for (int i = 0; i < A.length; i ++) {
            int l, r;
            if (A[i] == i) {
                tag[0] ++;
                tag[1] --;
                tag[i + 1] ++;
                tag[A.length] --;
            } else if (A[i] < i) {
                tag[0] ++;
                tag[i - A[i] + 1] --;
                tag[i + 1] ++;
                tag[A.length] --;
            } else {
                tag[i + 1] ++;
                tag[i + A.length - A[i] + 1] --;
            }
        }
        int tmp = 0;
        for (int i = 0; i < A.length; i ++) {
            tmp += tag[i];
            if (tmp > maxn) {
                maxn = tmp;
                k = i;
            }
        }
        return k;
    }
}