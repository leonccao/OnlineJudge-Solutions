class Solution {
    final static int[][] MV = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int minimumObstacles(int[][] grid) {
        // init
        int m = grid.length;
        int n = grid[0].length;
        Map<String, Integer> dist = new HashMap<>();
        dist.put(Arrays.toString(new int[]{0, 0}), 0);
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        pq.offer(new int[]{0, 0, 0});
        
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return cur[2];
            }
            
            for (int[] move : MV) {
                int[] newPos = new int[]{cur[0] + move[0], cur[1] + move[1]};
                if (newPos[0] < 0 || newPos[0] >= m || newPos[1] < 0 || newPos[1] >= n) {
                    continue;
                }
                
                int newDist = cur[2] + grid[newPos[0]][newPos[1]];
                if (newDist >= dist.getOrDefault(Arrays.toString(newPos), Integer.MAX_VALUE)) {
                    continue;
                }
                
                dist.put(Arrays.toString(newPos), newDist);
                pq.offer(new int[]{newPos[0], newPos[1], newDist});
            }
        }
        return -1;
    }
}