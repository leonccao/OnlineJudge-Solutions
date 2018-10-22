class Solution {
    public boolean survive(int hp, int[][] dungeon) {
        int[][] adv = new int[dungeon.length][dungeon[0].length];
        adv[0][0] = hp + dungeon[0][0];
        if (adv[0][0] <= 0) return false;
        for (int i = 0; i < dungeon.length; i ++)
            for (int j = 0; j < dungeon[0].length; j ++) {
                if (i == 0 && j == 0) continue;
                adv[i][j] = Integer.MIN_VALUE;
                if (i > 0 && adv[i - 1][j] > Integer.MIN_VALUE)
                    adv[i][j] = Math.max(adv[i][j], adv[i - 1][j] + dungeon[i][j]);
                if (j > 0 && adv[i][j - 1] > Integer.MIN_VALUE)
                    adv[i][j] = Math.max(adv[i][j], adv[i][j - 1] + dungeon[i][j]);
                if (adv[i][j] <= 0) adv[i][j] = Integer.MIN_VALUE;
            }
        if (adv[dungeon.length - 1][dungeon[0].length - 1] <= 0)
            return false;
        return true;
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        int r = 0;
        for (int[] row : dungeon)
            for (int block : row)
                if (block < 0)
                    r += -block;
        r += 2;
        int l = 1;
        while (l < r - 1) {
            System.out.println(l + " " + r);
            int mid = (l + r) / 2 - 1;
            if (survive(mid, dungeon)) r = mid + 1;
            else l = mid + 1;
        }
        return l;
    }
}