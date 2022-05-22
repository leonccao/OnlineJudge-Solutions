class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] left = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            left[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(left);
        
        int count = 0;
        int leftRocks = additionalRocks;
        for (int i = 0; i < left.length; i ++) {
            if (left[i] <= leftRocks) {
                count++;
                leftRocks -= left[i];
            } else {
                break;
            }
        }
        return count;
    }
}