/*
s: 5:21 PM
e: 5:34 PM
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] f = new int[len];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i ++)
            for (int j = i; j > -1; j --) {
                int tmp = Integer.MAX_VALUE;
                if (j < i ) tmp = Math.min(tmp, f[j]);
                if (j - 1 > -1)
                    tmp = Math.min(tmp, f[j - 1]);
                f[j] = tmp + triangle.get(i).get(j);
            }
        int result = Integer.MAX_VALUE;
        for (int num : f)
            result = Math.min(result, num);
        return result;
    }
}