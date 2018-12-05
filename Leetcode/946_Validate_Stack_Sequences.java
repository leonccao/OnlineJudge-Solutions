class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushCur = 0;
        for (int pop : popped) {
            if (!stack.isEmpty() && stack.peek() == pop) {
                stack.pop();
                continue;
            }
            while (pushCur != pushed.length) {
                stack.push(pushed[pushCur ++]);
                if (stack.peek() == pop) break;
            }
            if (!stack.isEmpty() && stack.peek() == pop) {
                stack.pop();
                continue;
            }
            return false;
        }
        return true;
    }
}