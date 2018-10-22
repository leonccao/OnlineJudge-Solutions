class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < n; i ++)
            graph.put(i, new HashSet<Integer>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return checkDFS(n, graph);
    }
    
    private boolean checkBFS(int n, Map<Integer, Set<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Set<Integer> set = graph.get(cur);
            for (int node : set) {
                if (visited.contains(node)) return false;
                visited.add(node);
                queue.add(node);
                graph.get(node).remove(cur);
            }
        }
        return visited.size() == n;
    }
    
    private boolean checkDFS(int n, Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        if (!DFSHelper(0, -1, graph, visited)) return false;
        return visited.size() == n;
    }
    
    private boolean DFSHelper(int index, int parent, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        Set<Integer> set = graph.get(index);
        for (int node : set) {
            if (node == parent) continue;
            if (visited.contains(node)) return false;
            visited.add(node);
            if (!DFSHelper(node, index, graph, visited)) return false;
        }
        return true;
    }
}