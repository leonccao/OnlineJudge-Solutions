class TimeMap {
    
    Map<String, List<Pair<Integer, String>>> timeMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        
        List<Pair<Integer, String>> list = timeMap.get(key);
        int pos = Collections.binarySearch(list, new Pair<Integer, String>(timestamp, "search"),
                                          (a, b) -> Integer.compare(a.getKey(), b.getKey()));
        
        if (pos >= 0) {
            return list.get(pos).getValue();
        }
        if (pos == -1) {
            return "";
        }
        return list.get(- pos - 2).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


 class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (! timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        
        TreeMap<Integer, String> treeMap = timeMap.get(key);
        Integer pos = treeMap.floorKey(timestamp);
        if (pos != null) {
            return treeMap.get(pos);
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */