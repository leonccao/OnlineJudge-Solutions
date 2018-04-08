class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        if (routes.length == 0) return -1;
        
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < routes.length; i ++) {
            if (routes[i].length < 2) continue;
            int[] route = routes[i];
            for (int start : route) {
                List<Integer> path;
                if (map.containsKey(start))
                    path = map.get(start);
                else path = new LinkedList<Integer>();
                
                path.add(i);
                map.put(start, path); 
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(S);
        HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        dist.put(S, 0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!map.containsKey(start)) continue;
            List<Integer> path = map.get(start);
            int curDist = dist.get(start) + 1;
            for (int route : path) {
                if (visited.contains(route)) continue;
                for (int end : routes[route]) {
                    if (dist.containsKey(end)) continue;
                    if (end == T) return curDist;
                    dist.put(end, curDist);
                    // System.out.println(end + " " + curDist);
                    queue.offer(end);
                }
                visited.add(route);
            }
        }
        return -1;
    }
}