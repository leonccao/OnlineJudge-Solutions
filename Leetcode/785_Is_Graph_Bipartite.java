/*
### Corner cases
1. Only one point
2. No self edge
3. Some node may not be connected

### Solution
1. BFS
    - Time complexity: O(n)
    - Space complexity: O(n)
2. DFS
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs

### Test cases
    0   false -> 1  true -> 3 true
    1   true  -> 2  false-> 0 false
    3   true  -> 2  false-> 0 false
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; i ++) {
            // has been visited
            if (map.containsKey(i)) continue;
            
            queue.add(i);
            map.put(i, false);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int node : graph[cur]) {
                    if (map.containsKey(node)) { // has been visited, check the color
                        if (map.get(node) == map.get(cur)) // the color on the two sides of an edge
                            return false;
                    } else {
                        map.put(node, !map.get(cur));
                        queue.add(node);
                    }
                }
            }
        }
        return true;
    }
}