class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int[] sum = new int[n];
        sum[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            sum[i + 1] = sum[i] + travel[i];
        }
        
        int[][] cnt = new int[n][3];
        for (int i = 0; i < n; i++) {
            String g = garbage[i];
            for (char ch : g.toCharArray()) {
                switch (ch) {
                    case 'M':
                        cnt[i][0]++;
                        break;
                    case 'P':
                        cnt[i][1]++;
                        break;
                    case 'G':
                        cnt[i][2]++;
                        break;
                }
            }
        }
        
        int result = 0;
        for (int g = 0; g < 3; g++) {
            int last = 0;
            for (int i = 0; i < n; i++) {
                if (cnt[i][g] > 0) {
                    result += cnt[i][g];
                    result += sum[i] - sum[last];
                    last = i;
                }
            }
        }
        return result;
    }
}