class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        
        int n = rooms.size() - 1;
        queue.add(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> keys = rooms.get(cur);
            for (int key : keys) {
                if (set.contains(key)) continue;
                n --;
                queue.add(key);
                set.add(key);
            }
        }
        if (n == 0) return true;
        else return false;
    }
}