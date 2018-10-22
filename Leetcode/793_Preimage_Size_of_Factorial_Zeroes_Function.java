class Solution {
    public int preimageSizeFZF(int K) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        long tmp = 1;
        while (tmp <= K) {
            list.add((int)tmp);
            tmp = tmp * 5 + 1;
        }
            
        for (int i = list.size() - 1; i >= 0; i --) {
            if (K == list.get(i) * 5) return 0;
            K %= list.get(i);
            if (K == 0) return 5;
        }
        return 5;        
    }
}