/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        for (TreeNode tmp = root; tmp != null; tmp = tmp.left)
            stack.push(tmp);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode rtn = stack.pop();
        for (TreeNode tmp = rtn.right; tmp != null; tmp = tmp.left)
            stack.push(tmp);
        return rtn.val;
    }
}

// new
public class BSTIterator {

    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (stack.peek().left != null)
                stack.push(stack.peek().left);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        if (cur.right != null) {
            stack.push(cur.right);
            while (stack.peek().left != null)
                stack.push(stack.peek().left);
        }
        return cur.val;
    }
}
