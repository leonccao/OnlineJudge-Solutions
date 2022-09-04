class Solution {
    public int maximumRobots(int[] c, int[] r, long b) {
        int n = c.length;
        
        LinkedList<int[]> q = new LinkedList<>();
        int tail = 0, max = 0;
        long sum = 0;
        for (int head = 0; head < n; head++) {
            while (!q.isEmpty() && q.peekLast()[1] <= c[head]) {
                q.pollLast();
            }
            q.add(new int[]{head, c[head]});
            sum += r[head];
            
            while (tail <= head && 
                  sum * (head - tail + 1) + q.peek()[1] > b) {
                sum -= r[tail++];
                while (!q.isEmpty() && q.peek()[0] < tail) {
                    q.pop();
                }
            }
            max = Math.max(max, head - tail + 1);
        }
        return max;
    }
}