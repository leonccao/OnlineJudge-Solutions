// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> cur;
    private boolean leftFlag;
    private int left;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        cur = iterator;
        leftFlag = false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (leftFlag) return left;
        leftFlag = true;
        left = cur.next();
        return left;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (leftFlag) {
            leftFlag = false;
            return left;
        }
        return cur.next();
	}

	@Override
	public boolean hasNext() {
	    return cur.hasNext() || leftFlag;
	}
}