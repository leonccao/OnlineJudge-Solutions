class Solution {
    
    Map<Integer, Set<Integer>> map;
    int xor;
    int flag = -1;
    int[] nums;
    int[][] edges;
    
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        this.edges = edges;
        
        map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
            set = map.getOrDefault(b, new HashSet<>());
            set.add(a);
            map.put(b, set);
        }
        
        Set<Integer> v = new HashSet<>();
        xor = 0;
        dfs(0, v);
        int sumXor = xor;
        Set<Integer>[] mapva = new Set[n];
        int[] mapxa = new int[n];
        
        
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            flag = i;
            
            v = new HashSet<>();
            xor = 0;
            dfs(a, v);
            mapva[i] = v;
            mapxa[i] = xor;
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            Set<Integer> va = mapva[i];
            int xa = mapxa[i];
            int xb = sumXor ^ xa;
            for (int j = i + 1; j < n - 1; j++) {
                
                int c = edges[j][0];
                int d = edges[j][1];
                Set<Integer> vc = mapva[j];
                int xc = mapxa[j];
                int xd = sumXor ^ xc;
                
                int x1, x2, x3;
                if (va.contains(c)) {
                    x1 = xb;
                    if (vc.contains(b)) {
                        x2 = xd;
                        x3 = xc ^ xb;
                    } else {
                        x2 = xc;
                        x3 = xd ^ xb;
                    }
                } else {
                    x1 = xa;
                    if (vc.contains(a)) {
                        x2 = xd;
                        x3 = xc ^ xa;
                    } else {
                        x2 = xc;
                        x3 = xd ^ xa;
                    }
                }
                result = Math.min(result, calc(x1, x2, x3));
                if (result == 0) {
                    return result;
                }
            }
        }
        return result;
    }
    
    private void dfs(int node, Set<Integer> v) {
        v.add(node);
        xor ^= nums[node];
        
        Set<Integer> set = map.get(node);
        for (Integer other : set) {
            if (v.contains(other)) {
                continue;
            }
            if (flag >= 0 && ((node == edges[flag][0] && other == edges[flag][1])
               || (node == edges[flag][1] && other == edges[flag][0]))) {
                continue;
            }
            dfs(other, v);
        }
    }
    
    private int calc(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        return max - min;
    }
}