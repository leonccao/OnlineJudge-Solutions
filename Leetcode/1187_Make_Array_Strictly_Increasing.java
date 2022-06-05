class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr2) {
            set.add(num);
        }
        
        int n = arr1.length;
        int[][] f = new int[n][n + 1];
        f[0][0] = arr1[0];
        f[0][1] = set.first();
        
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < i + 2; j ++) {
                f[i][j] = Integer.MAX_VALUE;
                
                if (j < i + 1 && f[i - 1][j] < arr1[i]) {
                    f[i][j] = arr1[i];
                }
                
                if (j > 0 && f[i - 1][j - 1] < Integer.MAX_VALUE) {
                    if (set.ceiling(f[i - 1][j - 1] + 1) == null) {
                        continue;
                    }
                    f[i][j] = Math.min(f[i][j], set.ceiling(f[i - 1][j - 1] + 1));
                }
                
            }
        }
        
        for (int i = 0; i < n + 1; i ++) {
            if (f[n - 1][i] < Integer.MAX_VALUE) {
                return i;
            }
        }
        return -1;
    }
}