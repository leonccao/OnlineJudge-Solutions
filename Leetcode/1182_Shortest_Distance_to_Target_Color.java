class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[] last = new int[4];
        last[1] = last[2] = last[3] = -1;
        int[][] rec = new int[colors.length][4];
        
        for (int i = 0; i < colors.length; i ++) {
            int cur = colors[i];
            last[cur] = i;
            for (int j = 1; j < 4; j ++) {
                rec[i][j] = last[j];
                //System.out.println(i + " " + j + " " + rec[i][j]);
            }
        }
        
        last[1] = last[2] = last[3] = -1;
        for (int i = colors.length - 1; i >= 0; i --) {
            int cur = colors[i];
            last[cur] = i;
            for (int j = 1; j < 4; j ++) {
                if (rec[i][j] == -1 || ((last[j] != -1) && (last[j] - i < i - rec[i][j]))) {
                    rec[i][j] = last[j];
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int cur = rec[query[0]][query[1]];
            if (cur == -1) {
                ans.add(cur);
            } else {
                ans.add(Math.abs(query[0] - cur));
            }
        }
        return ans;
    }
}