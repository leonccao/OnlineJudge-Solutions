class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;
        String[] nodes = preorder.split(",");
        Stack<Integer> stack = new Stack<Integer>();
        boolean root = false;
        for (String node : nodes) {
            if (node.equals("#")) {
                if (stack.isEmpty()) 
                    return false;
                int tmp = stack.pop() - 1;
                while (tmp == 0) {
                    if (stack.isEmpty()) break;
                    tmp = stack.pop() - 1;
                }
                if (tmp > 0) stack.push(tmp);
            } else {
                if (!stack.isEmpty())
                    stack.push(2);
                else {
                    if (!root) {
                        stack.push(2);
                        root = true;
                    } else return false;
                }
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}