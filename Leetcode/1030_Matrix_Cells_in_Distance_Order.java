// sort
class Solution {
    public class Point {
        int x, y, dist;
        public Point(int x, int y, int r0, int c0) {
            this.x = x;
            this.y = y;
            dist = Math.abs(x - r0) + Math.abs(y - c0);
        }
    }
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Point[] points = new Point[R * C];
        int cnt = 0;
        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j ++) {
                points[cnt ++] = new Point(i, j, r0, c0);
            }
        }
        
        Arrays.sort(points, (Point a, Point b) -> a.dist - b.dist);
        
        int[][] ans = new int[R * C][2];
        for (int i = 0; i < points.length; i ++) {
            ans[i][0] = points[i].x;
            ans[i][1] = points[i].y;
        }
        return ans;
    }
}

// BFS
class Solution {
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ans = new int[R * C][2];
        int cnt = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        Set<String> set = new HashSet<>();
        set.add("" + r0 + "," + c0);
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            ans[cnt ++] = cur;
            
            for (int[] mv : MV) {
                int x = cur[0] + mv[0], y = cur[1] + mv[1];
                if (x < 0 || x >= R || y < 0 || y >= C) continue;
                
                String nxts = "" + x + "," + y;
                if (set.contains(nxts)) continue;
                set.add(nxts);
                queue.offer(new int[]{x, y});
            }
        }
        return ans;
    }
}