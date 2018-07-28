class Solution {
    final static int MO = 1337;
    
    private int calcPow(int a, ArrayList<Integer> pow) {
        if (pow.isEmpty()) return 1;
        
        int carry = 0;
        for (int i = pow.size() - 1; i >= 0; i --) {
            int tmp = carry * 10 + pow.get(i);
            if (tmp % 2 != 0) carry = 1;
            else carry = 0;
            pow.set(i, tmp / 2);
        }
        if (pow.get(pow.size() - 1) == 0)
            pow.remove(pow.size() - 1);
        
        int tmp = calcPow(a, pow);
        tmp = tmp * tmp % MO;
        if (carry > 0) tmp = tmp * a % MO;
        return tmp;
    }
    
    public int superPow(int a, int[] b) {
        a = a % MO;
        ArrayList<Integer> pow = new ArrayList<Integer>();
        for (int i = b.length - 1; i >= 0; i --)
            pow.add(b[i]);
        
        return calcPow(a, pow);
    }
}