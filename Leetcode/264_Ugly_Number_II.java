class Solution {
    public int nthUglyNumber(int n) {
        int rank = 1;
        List<Integer> ugly = new ArrayList<Integer>();
        ugly.add(1);
        int node2 = 0, node3 = 0, node5 = 0;
        int last = 1;
        while (rank < n) {
            if (ugly.get(node2) * 2 == last) node2 ++;
            if (ugly.get(node3) * 3 == last) node3 ++;
            if (ugly.get(node5) * 5 == last) node5 ++;
            int tmp2 = ugly.get(node2) * 2;
            int tmp3 = ugly.get(node3) * 3;
            int tmp5 = ugly.get(node5) * 5;
            if (tmp2 <= tmp3 && tmp2 <= tmp5) {
                ugly.add(tmp2);
                last = tmp2;
                node2 ++;
            } else if (tmp3 <= tmp2 && tmp3 <= tmp5) {
                ugly.add(tmp3);
                last = tmp3;
                node3 ++;
            } else if (tmp5 <= tmp3 && tmp5 <= tmp3) {
                ugly.add(tmp5);
                last = tmp5;
                node5 ++;
            }
            rank ++;
        }
        return last;
    }
}