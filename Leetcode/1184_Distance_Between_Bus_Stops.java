class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int dist : distance) {
            sum += dist;
        }
        
        if (start > destination) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }
        
        int[] prefix = new int[distance.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < distance.length; i ++) {
            prefix[i + 1] = prefix[i] + distance[i];
        }
        
        int ans = prefix[destination] - prefix[start];
        ans = Math.min(ans, sum - ans);
        return ans;
    }
}