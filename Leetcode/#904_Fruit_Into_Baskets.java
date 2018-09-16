class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length == 0) return 0;
        int typea = -1, typeb = -1;
        int lasta = -1, lastb = -1;
        int rec = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < tree.length; i ++) {
            int type = tree[i];
            if (type == typea) {
                rec ++;
                lasta = i;
            } else if (type == typeb) {
                rec ++;
                lastb = i;
            } else if (lasta < lastb) {
                rec = i - lasta;
                typea = type;
                lasta = i;
            } else {
                rec = i - lastb;
                typeb = type;
                lastb = i;
            }
            ans = Math.max(ans, rec);
        }
        return ans;
    }
}