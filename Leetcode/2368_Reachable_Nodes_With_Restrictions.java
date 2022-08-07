class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> v = new HashSet<>();
        
        Set<Integer> r = new HashSet<>();
        for (int node : restricted) {
            r.add(node);
        }
        v.add(0);
        int result = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            Set<Integer> nbs = map.get(cur);
            for (int nb : nbs) {
                if (r.contains(nb) || v.contains(nb)) {
                    continue;
                }
                q.offer(nb);
                v.add(nb);
                result++;
            }
        }
        return result;
    }
}