class Solution {
    public long totalCost(int[] costs, int k, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < costs.length; i++) {
            deque.addLast(new int[]{costs[i], i});
        }
        
        for (int i = 0; i < c && !deque.isEmpty(); i++) {
            int[] cur = deque.removeFirst();
            pq.add(new int[]{cur[0], cur[1], 0});
        }
        for (int i = 0; i < c && !deque.isEmpty(); i++) {
            int[] cur = deque.removeLast();
            pq.add(new int[]{cur[0], cur[1], 1});
        }
        
        long result = 0;
        for (int i = 0; i < k; i++) {
            int[] cur = pq.poll();
            result += cur[0];
            if (!deque.isEmpty()) {
                int[] next;
                if (cur[2] == 0) {
                    next = deque.removeFirst();
                    pq.add(new int[]{next[0], next[1], 0});
                } else {
                    next = deque.removeLast();
                    pq.add(new int[]{next[0], next[1], 1});
                }
            }
        }
        return result;
    }
}