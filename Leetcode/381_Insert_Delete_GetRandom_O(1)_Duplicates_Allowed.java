class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean rtn = !map.containsKey(val);
        
        Set<Integer> set;
        if (rtn) {
            set = new HashSet<Integer>();
            map.put(val, set);
        } else set = map.get(val);
        list.add(val);
        set.add(list.size() - 1);
        
        return rtn;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        
        int pos = list.size() - 1;
        if (list.get(pos) != val) {
            pos = map.get(val).iterator().next();
            int tmp = list.get(list.size() - 1);
            list.set(pos, tmp);
            Set<Integer> setTmp = map.get(tmp);
            setTmp.remove(list.size() - 1);
            setTmp.add(pos);
        }
        list.remove(list.size() - 1);
        Set<Integer> set = map.get(val);
        set.remove(pos);
        if (set.isEmpty()) map.remove(val);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

// new
class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean rtn = !map.containsKey(val);
        list.add(val);
        if (!map.containsKey(val)) map.put(val, new HashSet<>());
        map.get(val).add(list.size() - 1);
        return rtn;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int swapee = list.get(list.size() - 1);
        if (swapee != val) {
            int swaperPos = map.get(val).iterator().next();
            list.set(swaperPos, swapee);
            map.get(val).remove(swaperPos);
            map.get(swapee).add(swaperPos);
        }
        map.get(swapee).remove(list.size() - 1);
        if (map.get(val).isEmpty()) map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
