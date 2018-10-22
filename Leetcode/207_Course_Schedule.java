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

/*
# Clarify:
1. Prerequisite be itself?
2. Two courses same pre
3. One courses several pres

# Bugs:
1. Some point may not appear in pre[] (new them all in map)
2. The edge is directed
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; i ++)
            graph.put(i, new ArrayList<Integer>());
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            graph.get(a).add(b);
        }
        return checkBFS(numCourses, graph);
    }
    
    private boolean checkDFS(int num, Map<Integer, List<Integer>> graph) {
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for (int i = 0; i < num; i ++)
            if (!DFSHelper(i, graph, visited))
                return false;
        return true;
    }
    
    private boolean DFSHelper(int index, Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited) {
        if (visited.containsKey(index))
            return visited.get(index);
        visited.put(index, false);
        for (int i = 0; i < graph.get(index).size(); i ++)
            if (!DFSHelper(graph.get(index).get(i), graph, visited))
                return false;
        visited.put(index, true);
        return true;
    }
    
    private boolean checkBFS(int num, Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> degree = new HashMap<Integer, Integer>(); // indegree
        for (int i = 0; i < num; i ++) {
            List<Integer> edges = graph.get(i);
            for (int node : edges)
                degree.put(node, degree.getOrDefault(node, 0) + 1);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < num; i ++)
            if (!degree.containsKey(i))
                queue.add(i);
        
        int visited = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited ++;
            List<Integer> edges = graph.get(cur);
            for (int node : edges) {
                degree.put(node, degree.get(node) - 1);
                if (degree.get(node) == 0)
                    queue.add(node);
            }
        }
        return visited == num;
    }
}