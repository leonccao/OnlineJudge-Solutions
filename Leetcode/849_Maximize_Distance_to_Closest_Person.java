class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] left  = new int[seats.length];
        int[] right = new int[seats.length];
        for (int i = 1; i < seats.length; i ++) {
            if (seats[i] == 1) left[i] = 0;
            else left[i] = left[i - 1] + 1;
        }
        for (int i = seats.length - 2; i >= 0; i --) {
            if (seats[i] == 1) right[i] = 0;
            else right[i] = right[i + 1] + 1;
        }
        left[0] = Integer.MAX_VALUE;
        right[seats.length - 1] = Integer.MAX_VALUE;
        
        int ans = 0;
        for (int i = 0; i < seats.length; i ++) {
            int tmp = Math.min(left[i], right[i]);
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}