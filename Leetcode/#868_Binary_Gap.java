class Solution {
    public int binaryGap(int N) {
        int dist = 0;
        int count = -1;
        while (N > 0) {
            int tmp = N % 2;
            if (tmp == 1) {
                dist = Math.max(dist, count + 1);
                count = 0; 
            } else {
                if (count != -1)
                    count ++;
            }
            N /= 2;
        }
        return dist;
    }
}