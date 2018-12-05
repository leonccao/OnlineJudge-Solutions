class Solution {
    
    final static int BASE = 10000;
    
    Map<Integer, Integer> father;
    
    private void union(int a, int b) {
        int p = find(a);
        int q = find(b);
        if (p != q) father.put(q, p);
    }
    
    private int find(int x) {
        if (father.get(x) == x) return x;
        father.put(x, find(father.get(x)));
        return father.get(x);
    }
    
    public int removeStones(int[][] stones) {
        father = new HashMap<>();
        int sum = 0;
        for (int[] stone : stones) {
            if (!father.containsKey(stone[0]))
                father.put(stone[0], stone[0]);
            if (!father.containsKey(stone[1] + BASE))
                father.put(stone[1] + BASE, stone[1] + BASE);
            union(stone[0], stone[1] + BASE);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i ++)
            set.add(find(stones[i][0]));
        return stones.length - set.size();
    }
}