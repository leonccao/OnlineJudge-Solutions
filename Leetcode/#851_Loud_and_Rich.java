class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i ++)
            map.put(i, new ArrayList<Integer>());
        
        for (int[] rich : richer)
            map.get(rich[1]).add(rich[0]);
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i ++)
            ans[i] = i;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i ++) {
            queue.clear();
            set.clear();
            queue.add(i);
            set.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                List<Integer> edges = map.get(cur);
                for (int end : edges) {
                    if (set.contains(end)) continue;
                    if (quiet[end] < quiet[ans[i]])
                        ans[i] = end;
                    queue.add(end);
                    set.add(end);
                }
            }
        }
        return ans;
    }
}