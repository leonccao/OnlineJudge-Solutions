class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        int last = 0, ans = 0;
        for (int i = 0; i < stations.length; i ++) {
            while (stations[i][0] - last > startFuel) {
                if (pq.isEmpty()) return -1;
                ans ++;
                startFuel += pq.poll();
            }
            startFuel -= stations[i][0] - last;
            pq.add(stations[i][1]);
            last = stations[i][0];
        }
        
        while (target - last > startFuel) {
            if (pq.isEmpty()) return -1;
            ans ++;
            startFuel += pq.poll();
        }
        return ans;
    }
}