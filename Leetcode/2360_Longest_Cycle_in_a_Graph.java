class Solution {
    public int longestCycle(int[] edges) {
        
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        
        int result = -1;
        
        for (int i = 0; i < edges.length; i++) {
            if (color.containsKey(i)) {
                continue;
            }
            
            
            int cur = i, distance = 0, start = i;
            color.put(i, start);
            dist.put(i, distance);
            
            while (cur != -1) {
                distance++;
                int next = edges[cur];
                
                if (next == -1) {
                    break;
                }
                
                if (color.containsKey(next)) {
                    if (color.get(next) == start) {
                        int tmp = distance - dist.get(next);
                        result = Math.max(result, tmp);
                    }
                    break;
                }
                
                    
                color.put(next, start);
                dist.put(next, distance);
                cur = next;
            }  
        }
        return result;
    }
}