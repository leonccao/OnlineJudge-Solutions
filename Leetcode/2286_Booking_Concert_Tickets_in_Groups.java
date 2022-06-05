class BookMyShow {
    
    class SegmentTree {
        private class Node {
            int l, r, max;
            long sum, pendingVal;
            Node childL, childR;
            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }
        
        public Node root;
        
        public SegmentTree(int n) {
            root = new Node(0, n - 1);
            build(root, 0, n - 1);
        }
        
        // Query and update within the same function 
        public int[] queryGather(Node node, int k, int maxRow) {
            if (node.max < k || node.sum < k || node.l > maxRow) {
                return new int[0];
            }
            if (node.l == node.r) {
                int[] result = {node.l, maxSeats - node.max};
                node.max -= k;
                node.sum -= k;
                return result;
            }
                        
            propagate(node);
            int[] result = queryGather(node.childL, k, maxRow);
            if (result.length == 0) {
                result = queryGather(node.childR, k, maxRow);
            }
            
            if (result.length > 0) {
                update(node);
            }
            return result;
        }
        
        public long queryScatter(Node node, int k, int maxRow) {            
            if (maxRow < node.l) {
                return 0;
            }
            if (node.l == node.r || node.r <= maxRow) {
                return node.sum;
            }
            
            propagate(node);
            long leftRes = queryScatter(node.childL, k, maxRow);
            if (leftRes >= k) {
                return leftRes;
            }
            return leftRes + queryScatter(node.childR, k - (int)leftRes, maxRow);
        }
        
        public void updateScatter(Node node, int k, int maxRow) {
            if (k == 0 || maxRow < node.l) {
                return;
            }
            if (node.l == node.r) {
                node.max -= k;
                node.sum -= k;
                return;
            }
            if (node.r <= maxRow) {
                mark(node, k);
                return;
            }
            
            propagate(node);
            if (k <= node.childL.sum) {
                updateScatter(node.childL, k, maxRow);
            } else {
                int leftSum = (int)node.childL.sum;
                updateScatter(node.childL, leftSum, maxRow);
                updateScatter(node.childR, k - leftSum, maxRow);
            }
            
            update(node);
        }
        
        private void build(Node node, int l, int r) {
            if (l == r) {
                node.sum = node.max = maxSeats;
                return;
            }
            
            int mid = (l + r) / 2;
            node.childL = new Node(l, mid);
            node.childR = new Node(mid + 1, r);
            build(node.childL, l, mid);
            build(node.childR, mid + 1, r);
            
            update(node);
        }
    
        private void update(Node node) {
            node.sum = node.childL.sum + node.childR.sum;
            node.max = Math.max(node.childL.max, node.childR.max);
        }
        
        private void propagate(Node node) {
            if (node.pendingVal == 0) {
                return;
            }
            if (node.pendingVal <= node.childL.sum) {
                mark(node.childL, node.pendingVal);
            } else {
                long leftSum = node.childL.sum;
                mark(node.childL, leftSum);
                mark(node.childR, node.pendingVal - leftSum);
            }
            node.pendingVal = 0;
        }
        
        private void mark(Node node, long k) {
            node.pendingVal += k;
            node.sum -= k;
            if (node.l == node.r) {
                node.max -= k;
            }
        }
    }
    
    SegmentTree tree;
    int maxSeats;

    public BookMyShow(int n, int m) {
        maxSeats = m;
        tree = new SegmentTree(n);
    }
    
    public int[] gather(int k, int maxRow) {
        return tree.queryGather(tree.root, k, maxRow);
    }
    
    public boolean scatter(int k, int maxRow) {
        long sum = tree.queryScatter(tree.root, k, maxRow);
        if (sum >= k) {
            tree.updateScatter(tree.root, k, maxRow);
            return true;
        }
        return false;
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */