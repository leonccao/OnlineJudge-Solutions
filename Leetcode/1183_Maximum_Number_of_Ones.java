class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] cnt = new int[sideLength][sideLength];
        for (int i = 0; i < width; i ++) {
            for (int j = 0; j < height; j ++) {
                cnt[i % sideLength][j % sideLength] ++;
            }
        }
        
        List<Integer> cntSort = new ArrayList<>();
        for (int i = 0; i < sideLength; i ++) {
            for (int j = 0; j < sideLength; j ++) {
                cntSort.add(cnt[i][j]);
            }
        }
        Collections.sort(cntSort, Collections.reverseOrder());
        
        int ans = 0;
        for (int i = 0; i < maxOnes; i ++) {
            ans += cntSort.get(i);
        }
        return ans;
    }
}