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

// new 
class Solution {
    public int totalFruit(int[] tree) {
        int type1, type2, last1, last2, hold1, hold2, ans;
        type1 = type2 = last1 = last2 = -1;
        hold1 = hold2 = ans = 0;
        
        for (int i = 0; i < tree.length; i ++) {
            if (type1 == tree[i] || type2 == tree[i]) {
                if (type1 == tree[i]) { 
                    hold1 ++; last1 = i; 
                } else { 
                    hold2 ++; last2 = i; 
                }
            } else {
                if (last1 < last2) { 
                    hold2 = i - 1 - last1;
                    type1 = tree[i]; 
                    last1 = i; 
                    hold1 = 1;  
                } else { 
                    hold1 = i - 1 - last2;
                    type2 = tree[i]; 
                    last2 = i; 
                    hold2 = 1; 
                }
            }
            ans = Math.max(ans, hold1 + hold2);
        }
        return ans;
    }
}