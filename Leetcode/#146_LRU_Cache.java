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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */