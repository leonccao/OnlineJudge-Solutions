class MyQueue {
    Stack<Integer> stack, back;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        back = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty())
            back.push(stack.pop());
        int tmp = back.pop();
        while (!back.isEmpty())
            stack.push(back.pop());
        return tmp;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty())
            back.push(stack.pop());
        int tmp = back.peek();
        while (!back.isEmpty())
            stack.push(back.pop());
        return tmp;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */