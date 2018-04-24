class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List> map = new HashMap<Integer, List>();
        for (int i = 0; i < numCourses; i ++)
            map.put(i, new LinkedList<Integer>());
        int[] d = new int[numCourses];
        for (int[] edge : prerequisites) {
            map.get(edge[1]).add(edge[0]);
            d[edge[0]] ++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i ++)
            if (d[i] == 0)
                queue.offer(i);
        int outQue = 0;
        while (!queue.isEmpty()) {
            outQue ++;
            int start = queue.poll();
            List<Integer> edges = map.get(start);
            for (int end : edges)
                if (-- d[end] == 0)
                    queue.offer(end);
        }
        
        if (outQue == numCourses) 
            return true;
        else return false;
    }
}