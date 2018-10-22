class Solution {
    class TurnPoint {
        int pos;
        int height;
        TurnPoint next = null;
        TurnPoint(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        TurnPoint[] builds = new TurnPoint[buildings.length * 2];
        int len = 0;
        for (int[] build : buildings) {
            TurnPoint left  = new TurnPoint(build[0], build[2]);
            TurnPoint right = new TurnPoint(build[1], build[2]);
            left.next = right;
            builds[len ++] = left;
            builds[len ++] = right;
        }
        Arrays.sort(builds, new Comparator<TurnPoint>() {
            public int compare(TurnPoint a, TurnPoint b) {
                return a.pos - b.pos;
            }
        });
        
        PriorityQueue<TurnPoint> pq = new PriorityQueue<TurnPoint>(
            new Comparator<TurnPoint>() {
                public int compare(TurnPoint a, TurnPoint b) {
                    return b.height - a.height;
                }
            });        
        List<int[]> ans = new LinkedList<int[]>();
        int last = -1;
        int cur = 0;
        while (cur < len) {
            int base = builds[cur].pos;
            while (cur < len && builds[cur].pos == base) {
                TurnPoint tp = builds[cur];
                while (!pq.isEmpty() && pq.peek().pos <= tp.pos)
                    pq.poll();
                if (tp.next != null)
                    pq.add(tp.next);
                
                cur ++;
            
                // System.out.println(tp.pos + " " + h);
            }
            
            int h = pq.isEmpty() ? 0 : pq.peek().height;
            if (h != last) {
                int[] tmp = new int[2];
                tmp[0] = base;
                tmp[1] = h;
                ans.add(tmp);
                last = h;
            }
        }
        return ans;
    }
}