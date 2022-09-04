class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<long[]> wait = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? 
                Long.compare(a[1], b[1]) :
                Long.compare(a[0], b[0])
        );
        PriorityQueue<Integer> free = new PriorityQueue<>();
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < n; i++) {
            free.offer(i);
        }
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            while (!wait.isEmpty() && wait.peek()[1] <= start) {
                free.offer((int)(wait.poll()[0]));
            }
            if (free.isEmpty()) {
                long[] tmp = wait.poll();
                end = tmp[1] + end - start;
                free.offer((int)tmp[0]);
            }
            int room = free.poll();
            count[room]++;
            
            wait.offer(new long[]{room, end});
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }
        return result;
    }
}