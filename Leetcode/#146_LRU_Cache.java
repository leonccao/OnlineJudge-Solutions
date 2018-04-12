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