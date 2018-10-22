class MovingAverage {
    
    Queue<Integer> queue;
    final int limit;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        limit = size;
        sum = 0;
    }
    
    public double next(int val) {
        queue.add(val);
        sum += val;
        if (queue.size() > limit)
            sum -= queue.poll();
        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */