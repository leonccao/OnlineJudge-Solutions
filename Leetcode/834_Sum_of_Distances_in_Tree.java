class Solution {
    public int calcSize(int cur, int[] size, Map<Integer, List> map, Set<Integer> set) {
        set.add(cur);
        size[cur] = 1;
        int coll = 0;
        
        List<Integer> list = map.get(cur);
        for (int end : list)
            if (!set.contains(end)) {
                coll += calcSize(end, size, map, set) + size[end];
                size[cur] += size[end];
            }
        
        return coll;
    }
    
    public void calcDist(int cur, int N, int coll, int[] dist, int[] size, Map<Integer, List> map, Set<Integer> set) {
        set.add(cur);
        dist[cur] = coll;
        
        List<Integer> list = map.get(cur);
        for (int end : list)
            if (!set.contains(end)) {
                calcDist(end, N, coll + N - 2 * size[end], dist, size, map, set);
            }
    }
    
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Map<Integer, List> map = new HashMap<Integer, List>();
        for (int i = 0; i < N; i ++)
            map.put(i, new LinkedList<Integer>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        int[] size = new int[N];
        Set<Integer> set = new HashSet<Integer>();
        int coll = calcSize(0, size, map, set);
        set.clear();
        int[] dist = new int[N];
        calcDist(0, N, coll, dist, size, map, set);
        return dist;
    }
}