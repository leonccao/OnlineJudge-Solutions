class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        
        if (amount[1] == 0) {
            return amount[2];
        }
        if (amount[0] == 0) {
            return Math.max(amount[1], amount[2]);
        }
        
        int left = amount[0] + amount[1];
        int right = amount[2];
        if (right >= left) {
            return right;
        }
        int limit = Math.min(amount[0], (left - right) / 2);
        return left - limit;
    }
}