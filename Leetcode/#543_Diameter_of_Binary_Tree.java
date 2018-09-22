/*
### Corner case
1. Input maybe empty
2. Path may or may not go through the root
3. Only one node: root

### Solution
1. Recursive
    - Time complexity: O(n)
    - Space complexity: O(1)

### Bugs

### Test cases

*/
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
    
    int maxn = Integer.MIN_VALUE;
    
    private int searchPath(TreeNode root) {
        int sum = 0, max = 0;
        if (root.left != null) {
            int tmp = searchPath(root.left) + 1;
            sum += tmp;
            max = Math.max(max, tmp);
        }
        if (root.right != null) {
            int tmp = searchPath(root.right) + 1;
            sum += tmp;
            max = Math.max(max, tmp);
        }
        maxn = Math.max(maxn, sum);
        return max;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        searchPath(root);
        return maxn;
    }
}