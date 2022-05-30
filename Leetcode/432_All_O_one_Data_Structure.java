class AllOne {
    
    private class BucketNode {
        int cnt;
        Set<String> set;
        BucketNode prev, next;
        
        BucketNode(int cnt) {
            this.cnt = cnt;
            set = new HashSet();
        }
    }
    
    private class BucketList {
        public BucketNode head, tail;
        private Map<Integer, BucketNode> bucketDict;
        
        BucketList() {
            head = new BucketNode(0);
            tail = new BucketNode(0);
            head.next = tail;
            tail.prev = head;
            bucketDict = new HashMap<>();
        }
        
        public Set<String> getFirstElement() {
            return head.next.set;
        }
        
        public Set<String> getLastElement() {
            return tail.prev.set;
        }
        
        public boolean isEmpty() {
            return head.next == tail;
        }
        
        public void remove(BucketNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            bucketDict.remove(node.cnt);
        }
        
        public BucketNode get(int cnt) {
            BucketNode node = bucketDict.get(cnt);
            if (node != null) {
                return node;
            }
            
            // Node doesn't exist in dict
            // Create a new one
            node = new BucketNode(cnt);
            bucketDict.put(cnt, node);
            
            BucketNode nextNode = bucketDict.get(cnt - 1);
            BucketNode prevNode = bucketDict.get(cnt + 1);
            if (cnt == 1) { // Case a. 1 --> tail
                insertPrev(node, tail);
            } else if (nextNode != null) { // Case b. cnt + 1
                insertPrev(node, nextNode);
            } else if (prevNode != null) { // Case c. cnt - 1
                insertNext(node, prevNode);
            }
            return node;
        }
        
        private void insertPrev(BucketNode node, BucketNode nextNode) {
            node.prev = nextNode.prev;
            node.next = nextNode;
            node.prev.next = node;
            node.next.prev = node;
        }
        
        private void insertNext(BucketNode node, BucketNode prevNode) {
            node.next = prevNode.next;
            node.prev = prevNode;
            node.prev.next = node;
            node.next.prev = node;
        }
    }

    Map<String, Integer> dict;
    BucketList bucketList;
    
    public AllOne() {
        dict = new HashMap<>();
        bucketList = new BucketList();
    }
    
    public void inc(String key) {
        increase(key, dict.getOrDefault(key, 0));
    }
    
    public void dec(String key) {
        decrease(key, dict.get(key));
    }
    
    public String getMaxKey() {
        if (bucketList.isEmpty()) {
            return "";
        }
        return bucketList.getFirstElement().iterator().next();
    }
    
    public String getMinKey() {
        if (bucketList.isEmpty()) {
            return "";
        }
        return bucketList.getLastElement().iterator().next();
    }
    
    
    /**
     * private functions
     **/
    
    private void increase(String key, int cnt) {
        Set<String> set = bucketList.get(cnt + 1).set;
        set.add(key);
        if (cnt > 0) {
            BucketNode bucketNode = bucketList.get(cnt);
            set = bucketNode.set;
            set.remove(key);
            if (set.isEmpty()) {
                bucketList.remove(bucketNode);
            }
        }
        dict.put(key, cnt + 1);
    }
    
    private void decrease(String key, int cnt) {
        Set<String> set;
        if (cnt > 1) {
            set = bucketList.get(cnt - 1).set;
            set.add(key);
            dict.put(key, cnt - 1);
        } else {
            dict.remove(key);
        }
        BucketNode bucketNode = bucketList.get(cnt);
        set = bucketNode.set;
        set.remove(key);
        if (set.isEmpty()) {
            bucketList.remove(bucketNode);
        }
    }
    
    private boolean isEmpty() {
        return bucketList.head.next == bucketList.tail;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */