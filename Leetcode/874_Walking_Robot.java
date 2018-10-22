class Solution {
    private final static int move[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private String coor2str(int x, int y) {
        return x + "," + y;
    }
    
    public int robotSim(int[] commands, int[][] obstacles) {
        
        Map<Integer, Set> map = new HashMap<Integer, Set>();
        for (int[] obst : obstacles) {
            Set<Integer> set;
            if (!map.containsKey(obst[0]))
                set = new HashSet<Integer>();
            else set = map.get(obst[0]);
            if (!set.contains(obst[1]))
                set.add(obst[1]);
            map.put(obst[0], set);
        }
        
        int curD = 0, curX = 0, curY = 0, ans = 0;
        for (int command : commands) {
            if (command == -2) {
                curD = (curD + 3) % 4;
            } else if (command == - 1) {
                curD = (curD + 1) % 4;
            } else {
                for (int i = 0; i < command; i ++) {
                    int nxtX = curX + move[curD][0];
                    int nxtY = curY + move[curD][1];
                    if (map.containsKey(nxtX) && map.get(nxtX).contains(nxtY)) {
                        break;
                    }
                    curX = nxtX;
                    curY = nxtY;
                }
                ans = Math.max(ans, curX * curX + curY * curY);
            }
        }
        return ans;
    }
}