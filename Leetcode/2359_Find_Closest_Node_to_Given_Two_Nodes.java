class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Map<Integer, Integer> dist1 = new HashMap<>();
        
        dist1.put(node1, 0);
        int cur = node1;
        while (cur != -1) {
            int next = edges[cur];
            if (next == -1 || dist1.containsKey(next)) {
                break;
            }
            dist1.put(next, dist1.get(cur) + 1);
            cur = next;
        }
        
        Map<Integer, Integer> dist2 = new HashMap<>();
        
        dist2.put(node2, 0);
        cur = node2;
        while (cur != -1) {
            int next = edges[cur];
            if (next == -1 || dist2.containsKey(next)) {
                break;
            }
            dist2.put(next, dist2.get(cur) + 1);
            cur = next;
        }
        
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (!dist1.containsKey(i) || !dist2.containsKey(i)) {
                continue;
            }
            int tmp = Math.max(dist1.get(i), dist2.get(i));
            if (tmp < min) {
                ans = i;
                min = tmp;
            }
        }
        return ans;
    }
}