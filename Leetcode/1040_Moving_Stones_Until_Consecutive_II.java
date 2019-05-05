class Solution {
    public int[] numMovesStonesII(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        int max = Math.max(s[n - 1] - s[1], s[n - 2] - s[0]) - n + 2;
        int min = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 1; j < n; j ++) {
            while (i < j && s[j] - s[i] > n - 1) i ++;
            if (j - i == n - 2 && s[j] - s[i] == n - 2)
                min = Math.min(min, 2);
            else min = Math.min(min, n - j + i - 1);
        }
        return new int[]{min, max};
    }
}