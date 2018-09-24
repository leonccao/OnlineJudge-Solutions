/*
### Corner cases
1. The integer division should truncate toward zero: positive or negative?

### Solution
1. Transform the midfix expression to suffix expression then calculate the value
    - Time complexity: O(n)
    - Space complexity: O(n)
    
### Bugs
1. The description said division truncates toward zero, however it is not. Division truncates to the floor.
2. Although intermediate value will be in the range of Integer, input value maybe out of range.

*/
class Solution {
    private int rank(char ch) {
        switch (ch) {
            case '$': return 0;
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
            case '/': return 2;
        }
        return -1;
    }
    
    private Queue<Object> mid2suf(String s) {
        s += '$';
        Queue<Object> queue = new LinkedList<Object>();
        Stack<Character> stack = new Stack<Character>();
        
        StringBuilder number = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (number.length() > 0) {
                    queue.add(Long.parseLong(number.toString()));
                    number = new StringBuilder();
                }
            } else if (Character.isDigit(ch)) {
                number.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (number.length() > 0) {
                    queue.add(Long.parseLong(number.toString()));
                    number = new StringBuilder();
                }
                while (stack.peek() != '(') {
                    queue.add(stack.pop());
                }
                stack.pop();
            } else {
                if (number.length() > 0) {
                    queue.add(Long.parseLong(number.toString()));
                    number = new StringBuilder();
                }
                while (!stack.isEmpty() && rank(ch) <= rank(stack.peek())) {
                    queue.add(stack.pop());
                }
                if (ch != '$') stack.push(ch);
            }
        }
        
        return queue;
    }
    
    private int calculate(Queue<Object> queue) {
        Stack<Long> operands = new Stack<Long>();
        for (Object obj : queue) {
            if (obj instanceof Long)
                operands.push((long)obj);
            else {
                char ch = (char)obj;
                long b = operands.pop();
                long a = operands.pop();
                long c = 0;
                switch (ch) {
                    case '+': c = a + b; break;
                    case '-': c = a - b; break;
                    case '*': c = a * b; break;
                    case '/': c = (long)Math.floor((double)a / b); break;
                }
                operands.push(c);
            }
        }
        long rtn = operands.peek();
        return (int)rtn;
    }
    
    public int calculate(String s) {
        Queue<Object> suffix = mid2suf(s);        
        return calculate(suffix);
    }
}