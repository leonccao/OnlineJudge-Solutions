class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] orderRow = getOrder(k, rowConditions);
        int[] orderCol = getOrder(k, colConditions);
        
        if (orderRow.length < k || orderCol.length < k) {
            return new int[0][0];
        }
        int[][] pos = new int[k][2];
        for (int i = 0; i < k; i++) {
            pos[orderRow[i]][0] = i;
            pos[orderCol[i]][1] = i;
        }
        int[][] result = new int[k][k];
        for (int i = 0; i < k; i++) {
            result[pos[i][0]][pos[i][1]] = i + 1;
        }
        return result;
    }
    
    private int[] getOrder(int k, int[][] conditions) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] d = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] condition : conditions) {
            int a = condition[0] - 1;
            int b = condition[1] - 1;
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            if (set.contains(b)) {
                continue;
            }
            set.add(b);
            d[b]++;
            map.put(a, set);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (d[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            Set<Integer> set = map.getOrDefault(cur, new HashSet<>());
            for (int nb : set) {
                if (--d[nb] <= 0) {
                    q.add(nb);
                }
            }
        }
        int[] order = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            order[i] = result.get(i);
        }
        return order;
    }
}