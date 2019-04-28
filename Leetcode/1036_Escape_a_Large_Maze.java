class Solution {
    final static int border = 1000000;
    
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private class Point {
        int x, y;
        String sign = "";
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            sign = "" + x + "," + y;
        }
        
        public Point(int[] a) {
            x = a[0];
            y = a[1];
            sign = "" + x + "," + y;
        }
        
        @Override
        public int hashCode() {
            return sign.hashCode();
        }
    }
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Point> block = new HashSet<>();
        for (int[] b : blocked) {
            block.add(new Point(b));
        }
        
        Set<Point> beginSet = new HashSet<>();
        Set<Point> endSet = new HashSet<>();
        Set<Point> visited = new HashSet<>();
        
        beginSet.add(new Point(source));
        endSet.add(new Point(target));
        visited.add(new Point(source));
        visited.add(new Point(target));
        
        int layer = 0;
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (layer ++ == 300) return true;
            if (beginSet.size() > endSet.size()) {
                Set<Point> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<Point> tmp = new HashSet<>();
            for (Point cur : beginSet) {
                for (int[] mv : MV) {
                    int x = cur.x + mv[0];
                    int y = cur.y + mv[1];
                    Point nxt = new Point(x, y);
                    if (x < 0 || x == border || y < 0 || y == border) {
                        continue;
                    }
                    
                    if (block.contains(nxt)) continue;
                    
                    if (endSet.contains(nxt)) return true;
                    
                    if (!visited.contains(nxt)) {
                        visited.add(nxt);
                        tmp.add(nxt);
                    }
                }
            }
            beginSet = tmp;
        }
        return false;
    }
}