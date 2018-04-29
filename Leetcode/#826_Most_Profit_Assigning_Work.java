class Solution {
    private class Node {
        int diff;
        int pro;
        Node(int diff, int pro) {
            this.diff = diff;
            this.pro = pro;
        }
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Node[] nodes = new Node[difficulty.length];
        for (int i = 0; i < difficulty.length; i ++)
            nodes[i] = new Node(difficulty[i], profit[i]);
        
        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return b.pro - a.pro;
            }
        });
            
        int len = 0;
        for (int i = 1; i < nodes.length; i ++)
            if (nodes[i].diff < nodes[len].diff)
                nodes[++ len] = nodes[i];
        
        //for (int i = 0; i <= len; i ++)
        //    System.out.println(nodes[i].diff + " " + nodes[i].pro);
        
        int ans = 0;
        for (int work : worker) {
            int l = 0, r = len + 1;
            while (l < r - 1) {
                // System.out.println(l + " " + r);
                int mid = (l + r) / 2 - 1;
                if (nodes[mid].diff <= work)
                    r = mid + 1;
                else l = mid + 1;
            }
            if (nodes[l].diff <= work)
                ans += nodes[l].pro;
        }
        return ans;
    }
}