/*
### Corner case
1. One new addLand connect two old land together

### Solution
1. Union-find. Increase count by one every time add a new land, check whether new land connect to some old land. Decrease count by one every time combination happens.
    - Time complexity: O(k log(mn))
    - Space complexity: O(mn)
    
*/
class Solution {
    
    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    int N;
    int[] father;
    
    private int translate(int x, int y) {
        return x * N + y;
    }
    
    private int translate(int[] addland) {
        return addland[0] * N + addland[1];
    }
    
    private int find(int x) {
        if (father[x] == x) return x;
        father[x] = find(father[x]);
        return father[x];
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        List<Integer> ans = new ArrayList<Integer>();
        boolean[] grid = new boolean[m * n];
        father = new int[m * n];
        N = n;
        
        int cnt = 0;
        for (int[] addland : positions) {
            cnt ++;
            int cur = translate(addland);
            grid[cur] = true;
            father[cur] = cur;
            
            int base = -1;
            for (int[] mv : MV) {
                int x = addland[0] + mv[0];
                int y = addland[1] + mv[1];
                if (x < 0 || x == m) continue;
                if (y < 0 || y == n) continue;
                if (grid[translate(x, y)]) {
                    base = translate(x, y);
                    break;
                }
            }
            if (base > -1) {
                int p = find(base);
                father[cur] = p;
                cnt --;
                for (int[] mv : MV) {
                    int x = addland[0] + mv[0];
                    int y = addland[1] + mv[1];
                    if (x < 0 || x == m) continue;
                    if (y < 0 || y == n) continue;
                    if (!grid[translate(x, y)]) continue;
                    int q = find(translate(x, y));
                    if (p != q) {
                        father[q] = p;
                        cnt --;
                    }
                }
            }
            
            ans.add(cnt);
        }
        
        return ans;
    }
}