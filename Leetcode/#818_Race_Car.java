class Solution {
    public int racecar(int target) {
        int[] s = new int[target + 1];
        Arrays.fill(s, Integer.MAX_VALUE);
        s[0] = 0;
        for (int tar = 1; tar <= target; tar ++) {
            int lim = 32 - Integer.numberOfLeadingZeros(tar);
            if (tar == (1 << lim) - 1) {
                s[tar] = lim;
                continue;
            }
            for (int back = 0; back < lim; back ++)
                s[tar] = Math.min(s[tar], s[tar - (1 << lim - 1) + (1 << back)] + lim + back + 1);
            if (tar > (1 << lim) - 1 - tar)
                s[tar] = Math.min(s[tar], s[(1 << lim) - 1 - tar] + lim + 1);
        }
        return s[target];
    }
}