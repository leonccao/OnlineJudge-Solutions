class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        boolean[] bad = new boolean[nodes];
        boolean[] good = new boolean[nodes];
        for (int i = 0; i < nodes; i ++) {
            if (good[i]) continue;
            if (bad[i]) continue;
            circle(i, visited, good, bad, graph);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nodes; i ++)
            if (!bad[i]) result.add(i);
        return result;
    }
    
    public boolean circle(int node, boolean[] visited, boolean[] good, boolean[] bad, int[][] graph) {
        if (visited[node]) {
            bad[node] = true;
            return true;
        }
        visited[node] = true;
        for (int i = 0; i < graph[node].length; i ++) {
            if (good[graph[node][i]]) continue;
            if (bad[graph[node][i]] || circle(graph[node][i], visited, good, bad, graph)) {
                visited[node] = false;
                bad[node] = true;
                return true;
            }
        }
        visited[node] = false;
        good[node] = true;
        return false;
    }
}