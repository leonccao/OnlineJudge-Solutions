class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ')' &&
                !stack.isEmpty() && 
                s.charAt(stack.peek()) == '(')
                    stack.pop();
            else stack.push(i);
            int tmp = stack.isEmpty() ? i + 1 : i - stack.peek();
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}