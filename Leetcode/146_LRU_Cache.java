class LRUCache {
    
    private class LRUList {
        public class ListNode {
            public int key, value;
            protected ListNode prev, next;
            
            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
                this.prev = null;
                this.next = null;
            }
            
            public ListNode(int key, int value, ListNode prev, ListNode next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }
        
        // head -- Most Recently Used
        // tail -- Lease Recently Used
        private ListNode head, tail;
        private int size, capacity;
        
        public LRUList(int capacity) {
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
            // if capacity < 1 throw error
            this.capacity = capacity;
        }
        
        public void update(ListNode node) {
            if (node == head || node == tail) {
                // Throw some error here
                return;
            }
            if (node.prev == head) {
                // Already at the head
                return;
            }
            remove(node);
            addToHead(node);
        }
        
        // Not pretty fond of passing map in here
        public ListNode insert(int key, int value, Map<Integer, ListNode> map) {
            if (size >= capacity) {
                ListNode lruNode = tail.prev;
                remove(lruNode);
                map.remove(lruNode.key);
            }
            
            ListNode node = new ListNode(key, value, head, head.next);
            addToHead(node);
            return node;
        }
        
        private void addToHead(ListNode node) {
            size++;
            
            node.next = head.next;
            node.prev = head;
            
            node.prev.next = node; // head
            node.next.prev = node; // original head.next
        }
        
        private void remove(ListNode node) {
            size--;
            
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    
    Map<Integer, LRUList.ListNode> map;
    LRUList list;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new LRUList(capacity);
    }
    
    public int get(int key) {
        LRUList.ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        list.update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        LRUList.ListNode node = map.get(key);
        if (node == null) {
            node = list.insert(key, value, map);
            map.put(key, node);
        } else {
            node.value = value;
            list.update(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache {

    class Block {
        int val, visit;
        Block(int val, int visit) {
            this.val = val;
            this.visit = visit;
        }
    }
    
    Map<Integer, Block> map;
    Queue<Integer> queue;
    
    int size, capacity, opCnt, pollCnt;
    
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Block>();
        queue = new LinkedList<Integer>();
        this.capacity = capacity;
        size = opCnt = pollCnt = 0;
    }
        
    public int get(int key) {
        int rtnVal;
        if (!map.containsKey(key) || (rtnVal = map.get(key).val) == -1) 
            return -1;
        opCnt ++;
        map.put(key, new Block(rtnVal, opCnt));
        queue.add(key);
        return rtnVal;
    }
    
    public void clearJunk() {
        if (size <= capacity) return;
        while (true) {
            pollCnt ++;
            int key = queue.poll();
            if (pollCnt == map.get(key).visit) {
                map.put(key, new Block(-1, -1));
                break;
            }
        }
        size --;
    }
    
    public void put(int key, int value) {
        opCnt ++;
        if (!map.containsKey(key) || map.get(key).val == -1) 
            size ++;
        clearJunk();
        map.put(key, new Block(value, opCnt));
        queue.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


class LRUCache {

    class DoublyLinkedList {
        int key, val;
        DoublyLinkedList prev, next;
        DoublyLinkedList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Map<Integer, DoublyLinkedList> map;
    int limit;
    DoublyLinkedList head;
    DoublyLinkedList tail;
    
    private void deleteDLL(DoublyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insertDLL(DoublyLinkedList node) {
        node.prev = tail.prev;
        node.next = tail;
        node.prev.next = node;
        node.next.prev = node;
    }
    
    public LRUCache(int capacity) {
        limit = capacity;
        map = new HashMap<Integer, DoublyLinkedList>();
        head = new DoublyLinkedList(0, 0);
        tail = new DoublyLinkedList(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DoublyLinkedList tmp = map.get(key);
        deleteDLL(tmp);
        insertDLL(tmp);
        return tmp.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedList tmp = map.get(key);
            tmp.val = value;
            deleteDLL(tmp);
            insertDLL(tmp);
            return;
        }
        
        DoublyLinkedList tmp = new DoublyLinkedList(key, value);
        map.put(key, tmp);
        insertDLL(tmp);
        if (map.size() > limit) {
            int rm = head.next.key;
            deleteDLL(head.next);
            map.remove(rm);
        }
    }
}


class LRUCache {

    class DDLNode {
        int key, val;
        DDLNode prev, next;
        DDLNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }
    
    private void insert(DDLNode node) {
        node.prev = tail.prev;
        node.next = tail;
        node.prev.next = node;
        node.next.prev = node;
    }
    
    private void remove(DDLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    int capacity;
    DDLNode head, tail;
    Map<Integer, DDLNode> map;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new DDLNode(0, 0);
        tail = new DDLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DDLNode cur = map.get(key);
        remove(cur); insert(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DDLNode cur = map.get(key);
            remove(cur); insert(cur);
            cur.val = value;
        } else {
            if (map.size() == capacity) {
                map.remove(head.next.key);
                remove(head.next);
            }
            DDLNode cur = new DDLNode(key, value);
            insert(cur);
            map.put(key, cur);
        }
    }
}