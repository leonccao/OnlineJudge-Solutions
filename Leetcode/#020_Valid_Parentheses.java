class Solution {
    private int translate(char ch) {
        switch (ch) {
            case '(': return 0;
            case '[': return 1;
            case '{': return 2;
            case ')': return 3;
            case ']': return 4;
            case '}': return 5;
        }
        return -1;
    }
    
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (char ch : s.toCharArray()) {
            int tmp = translate(ch);
            if (tmp < 3) stack.push(tmp);
            else {
                if (stack.isEmpty() || stack.peek() != tmp - 3)
                    return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}