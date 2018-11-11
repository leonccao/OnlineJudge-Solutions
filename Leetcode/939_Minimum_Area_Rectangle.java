class Solution {    
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i ++) {
            if (!map.containsKey(points[i][0]))
                map.put(points[i][0], new HashSet<>());
            map.get(points[i][0]).add(points[i][1]);
        }
        for (int i = 0; i < points.length; i ++)
            for (int j = i + 1; j < points.length; j ++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if ((map.containsKey(x1) && map.get(x1).contains(y2)) && (map.containsKey(x2) && map.get(x2).contains(y1))) {
                    int s = (int)(Math.abs(x1 - x2) * Math.abs(y1 - y2));
                    if (s > 0) ans = Math.min(ans, s);
                }
            }
        if (ans < Integer.MAX_VALUE) return ans;
        return 0;
    }
}