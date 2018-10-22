class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < fronts.length; i ++)
            if (fronts[i] == backs[i])
                set.add(fronts[i]);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i ++) {
            if (!set.contains(fronts[i]))
                ans = Math.min(ans, fronts[i]);
            if (!set.contains(backs[i]))
                ans = Math.min(ans, backs[i]);
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}