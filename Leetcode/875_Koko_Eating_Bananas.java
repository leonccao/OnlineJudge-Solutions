class Solution {
    private boolean check(int speed, int[] piles, int limit) {
        int time = 0;
        for (int pile : piles)
            time += (pile + speed - 1) / speed;
        
        //System.out.println(speed + " " + time);
        if (time <= limit) return true;
        return false;
    }
    
    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles)
            max = Math.max(max, pile);
        int l = 1, r = max + 1;
        while (l < r - 1) {
            int mid = (l + r) / 2 - 1;
            if (check(mid, piles, H)) r = mid + 1;
            else l = mid + 1;
        }
        return l;
    }
}