class Solution {
    
    public void bottomUp(int root, Set<Integer> appear, int[][] childDep, Map<Integer, List> e) {
        appear.add(root);
        List<Integer> edge = e.get(root);
        for (int end : edge) {
            if (appear.contains(end)) continue;
            bottomUp(end, appear, childDep, e);
            int tmpDep = childDep[end][0] + 1;
            if (tmpDep > childDep[root][0]) {
                childDep[root][1] = childDep[root][0];
                childDep[root][0] = tmpDep;
            } else if (tmpDep > childDep[root][1])
                childDep[root][1] = tmpDep;
        }
    }
    
    public void topDown(int root, int fatherDep, Set<Integer> appear, int[] depth, int[][] childDep, Map<Integer, List> e) {
        appear.add(root);
        depth[root] = Math.max(fatherDep, childDep[root][0]); // calc the depth from this node
        
        List<Integer> edge = e.get(root);
        for (int end : edge) {
            if (appear.contains(end)) continue;
            int tmpDep = childDep[root][0] == childDep[end][0] + 1 ? childDep[root][1] : childDep[root][0];
            tmpDep = Math.max(tmpDep, fatherDep) + 1;
            
            topDown(end, tmpDep, appear, depth, childDep, e);
        }
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List> e = new HashMap<Integer, List>();
        for (int i = 0; i < n; i ++)
            e.put(i, new ArrayList<Integer>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            e.get(a).add(b);
            e.get(b).add(a);
        }
        
        Set<Integer> appear = new HashSet<Integer>();
        int[][] childDep = new int[n][2]; // record the longest and second longest
        int root = 0;
        bottomUp(root, appear, childDep, e);
        
        int[] depth = new int[n];
        appear.clear();
        int fatherDep = 0;
        topDown(root, fatherDep, appear, depth, childDep, e);
        
        List<Integer> rec = new ArrayList<Integer>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++)
            if (depth[i] < ans) {
                ans = depth[i];
                rec.clear();
                rec.add(i);
            } else if (depth[i] == ans)
                rec.add(i);
        return rec;
    }
}