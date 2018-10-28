/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode a = queue.poll();
            UndirectedGraphNode a2 = map.get(a);
            List<UndirectedGraphNode> nb = a.neighbors;
            for (UndirectedGraphNode b : nb) {
                if (!map.containsKey(b)) {
                    map.put(b, new UndirectedGraphNode(b.label));
                    queue.offer(b);
                }
                UndirectedGraphNode b2 = map.get(b);
                a2.neighbors.add(b2);
            }
        }
        return map.get(node);
    }
}

// new BFS
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            List<UndirectedGraphNode> list = cur.neighbors;
            for (UndirectedGraphNode nb : list) {
                if (!map.containsKey(nb)) {
                    queue.add(nb);
                    map.put(nb, new UndirectedGraphNode(nb.label));
                }
                map.get(cur).neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }
}

// new DFS
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        map.put(node, new UndirectedGraphNode(node.label));
        List<UndirectedGraphNode> list = node.neighbors;
        for (UndirectedGraphNode nb : list)
            map.get(node).neighbors.add(cloneGraph(nb));
        return map.get(node);
    }
}