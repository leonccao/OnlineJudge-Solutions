class LFUCache {
    
    private class Node {
        int key, val, cnt;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }
    
    private class DLList {
        Node head, tail;
        int size;
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        public void insert(Node node) {
            node.prev = head;
            node.next = head.next;
            node.prev.next = node;
            node.next.prev = node;
            size++;
        }
        
        public int clean() {
            Node node = tail.prev;
            remove(node);
            return node.key;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
    }
    
    Map<Integer, Node> dict;
    Map<Integer, DLList> buckets;
    int capacity, size, min;

    public LFUCache(int capacity) {
        dict = new HashMap<>();
        buckets = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        min = Integer.MAX_VALUE;
    }
    
    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        
        Node node = dict.get(key);
        if (node != null) {
            update(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        Node node = dict.get(key);
        if (node != null) {
            node.val = value;
            update(node);
        } else {
            if (size >= capacity) {
                clean();
            }
            node = new Node(key, value);
            insert(node);
        }
        dict.put(key, node);
    }
    
    
    
    private void update(Node node) {
        DLList bucket = buckets.get(node.cnt);
        bucket.remove(node);
        if (bucket.size == 0 && min == node.cnt) {
            min++;
        }
        
        node.cnt++;
        bucket = buckets.getOrDefault(node.cnt, new DLList());
        bucket.insert(node);
        buckets.put(node.cnt, bucket);
    }
    
    private void clean() {
        DLList bucket = buckets.get(min);
        int key = bucket.clean();
        dict.remove(key);
        size--;
        // Will be 1 after the put operation
    }
    
    private void insert(Node node) {
        DLList bucket = buckets.getOrDefault(1, new DLList());
        bucket.insert(node);
        buckets.put(1, bucket);
        size++;
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */