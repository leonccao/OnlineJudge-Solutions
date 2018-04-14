class Solution {
    public void operate(Stack<Integer> stack, String token) {
        int b = stack.pop();
        int a = stack.pop();
        if (token.equals("+")) a += b;
        else if (token.equals("-")) a -= b;
        else if (token.equals("*")) a *= b;
        else if (token.equals("/")) a /= b;
        stack.push(a);
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) operate(stack, "+");
            else if (token.equals("-")) operate(stack, "-");
            else if (token.equals("*")) operate(stack, "*");
            else if (token.equals("/")) operate(stack, "/");
            else stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}