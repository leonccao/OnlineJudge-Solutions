class Solution {
    
    private int calc(int a, int b, int c, int d) {
        int hour = a * 10 + b;
        if (hour > 23) return -1;
        int minute = c * 10 + d;
        if (minute > 59) return -1;
        return hour * 100 + minute;
    }
    
    public String largestTimeFromDigits(int[] A) {
        String ans = "";
        int ansVal = -1;
        for (int i = 0; i < 4; i ++)
        for (int j = 0; j < 4; j ++) {
            if (i == j) continue;
            for (int k = 0; k < 4; k ++) {
                if (i == k || j == k) continue;
                for (int l = 0; l < 4; l ++) {
                    if (i == l || j == l || k == l) continue;
                    int tmp = calc(A[i], A[j], A[k], A[l]);
                    if (tmp > ansVal) {
                        ansVal = tmp;
                        ans = "" + A[i] + A[j] + ":" + A[k] + A[l];
                    }
                }
            }
            
        }
        
        return ans;
    }
}