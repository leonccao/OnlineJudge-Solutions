class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE - 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i ++)
            for (int coin : coins) {
                if (i < coin) continue;
                f[i] = Math.min(f[i], f[i - coin] + 1);
            }
        if (f[amount] < Integer.MAX_VALUE - 1)
            return f[amount];
        else return -1;
    }
}