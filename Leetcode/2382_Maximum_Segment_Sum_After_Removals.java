class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        long[] result = new long[nums.length];
        result[nums.length - 1] = 0;
        long max = 0;
        
        int[] record = new int[nums.length];
        int[] fa = new int[nums.length];
        long[] size = new long[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int addIndex = removeQueries[i + 1];
            int add = nums[addIndex];
            
            fa[addIndex] = addIndex;
            size[addIndex] = add;
            record[addIndex] = add;
            
            if (addIndex > 0 && record[addIndex - 1] > 0) {
                fa[addIndex - 1] = addIndex;
                size[addIndex] += size[addIndex - 1];
            }
            if (addIndex < nums.length - 1 && record[addIndex + 1] > 0) {
                fa[addIndex] = getFa(addIndex + 1, fa);
                size[fa[addIndex]] += size[addIndex];
            }
            max = Math.max(max, size[fa[addIndex]]);
            result[i] = max;
        }
        return result;
    }
    
    private int getFa(int index, int[] fa) {
        int cur = index;
        while (fa[cur] != cur) {
            fa[cur] = fa[fa[cur]];
            cur = fa[cur];
        }
        return cur;
    }
}