/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        return dig(root, sum, stack);
    }
    
    public int dig(TreeNode root, int sum, Stack<Integer> stack) {
        if (root == null) return 0;
        stack.push(stack.peek() + root.val);
        int result = 0;
        for (int i = 0; i < stack.size() - 1; i ++)
            if (stack.peek() - stack.elementAt(i) == sum)
                result ++;
        result += dig(root.left,  sum, stack);
        result += dig(root.right, sum, stack);
        stack.pop();
        return result;
    }
}