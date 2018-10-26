
public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i --)
            stack.add(nestedList.get(i));
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            nestedList = stack.pop().getList();
            for (int i = nestedList.size() - 1; i >= 0; i --)
                stack.add(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        int rtn = stack.pop().getInteger();
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> nestedList = stack.pop().getList();
            for (int i = nestedList.size() - 1; i >= 0; i --)
                stack.add(nestedList.get(i));
        }
        return rtn;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        return true;
    }
}

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i --)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> cur = stack.pop().getList();
            for (int i = cur.size() - 1; i >= 0; i --)
                stack.push(cur.get(i));
        }
        if (stack.isEmpty()) return false;
        return true;
    }
}

// new 
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i --)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> cur = stack.pop().getList();
            for (int i = cur.size() - 1; i >= 0; i --)
                stack.push(cur.get(i));
        }
        return !stack.isEmpty();
    }
}