/*
### Solution
1. According to the followup, better way here is using a list to hold iterators.
*/
public class ZigzagIterator {
    
    Queue<Iterator> queue;
        
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator>();
        if (!v1.isEmpty()) queue.add(v1.iterator());
        if (!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> tmp = queue.poll();
        int rtn = tmp.next();
        if (tmp.hasNext()) queue.add(tmp);
        return rtn;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */