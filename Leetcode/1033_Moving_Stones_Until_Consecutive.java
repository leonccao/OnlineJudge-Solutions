class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;
        
        int[] ans = new int[2];
        ans[0] = z - x - 2 == 0 ? 0 : Math.min(y - x - 1, z - y - 1) <= 1 ? 1 : 2;
        ans[1] = z - x - 2;
        return ans;
    }
}