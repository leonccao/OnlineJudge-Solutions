class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(0, result, path, graph);
        return result;
    }
    
    public void dfs(int now, ArrayList<List<Integer>> result,  ArrayList<Integer> path, int[][] graph) {
        path.add(now);
        if (now == graph.length - 1) {
            ArrayList<Integer> cpath = new ArrayList<Integer>();
            for (int n : path)
                cpath.add(n);
            result.add(cpath);
            path.remove(path.size() - 1);
            return;
        }
        int[] link = graph[now];
        for (int dest : link) {
            dfs(dest, result, path, graph);
        }
        path.remove(path.size() - 1);
    }
}