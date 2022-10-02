class Solution {
    
    int[] father;
    
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
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
        
        // 1 index 2 val
        int[][] sort = new int[vals.length][2];
        for (int i = 0; i < vals.length; i++) {
            sort[i][0] = i;
            sort[i][1] = vals[i];
        }
        Arrays.sort(sort, (a, b) -> a[1] - b[1]);
        
        boolean[] visited = new boolean[vals.length];
        father = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            father[i] = i;
        }
        
        int index = 0, ans = 0;
        while (index < vals.length) {
            List<Integer> list = new ArrayList<>();
            
            int valLimit = sort[index][1];
            for (; index < vals.length; index++) {
                if (sort[index][1] != valLimit) {
                    break;
                }
                visited[sort[index][0]] = true;
                list.add(sort[index][0]);
            }
            
            for (int num : list) {
                if (!map.containsKey(num)) {
                    continue;
                }
                Set<Integer> set = map.get(num);
                for (int nb : set) {
                    if (!visited[nb]) {
                        continue;
                    }
                    int faNum = get(num);
                    int faNb = get(nb);
                    if (faNum != faNb) {
                        father[faNb] = faNum;
                    }
                }
            }
            
            int[] fas = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                fas[i] = get(list.get(i));
            }
            Arrays.sort(fas);
            
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    count = 1;
                } else if (fas[i] == fas[i - 1]) {
                    count++;
                } else if (fas[i] != fas[i - 1]) {
                    ans += (count + 1) * count / 2;
                    count = 1;
                }
            }
            ans += (count + 1) * count / 2;
        }
        return ans;
    }
    
    int get(int cur) {
        int fa = father[cur];
        while (father[fa] != fa) {
            fa = father[fa];
        }
        father[cur] = fa;
        return fa;
    }
}