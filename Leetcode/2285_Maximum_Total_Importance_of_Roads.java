class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        Arrays.sort(degree);
        
        long result = 0;
        for (int i = n - 1; i >= 0; i--) {
            result += (long)(i + 1) * degree[i];
        }
        return result;
    }
}