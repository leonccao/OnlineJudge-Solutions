/*
### Corner cases
1. Input is empty
2. Input has only one node (point to itself?)
3. Is head the first or fakehead?

### Solution
1. Stack -> successor all the way down

### Bugs
1. Input is empty! I wrote it in the corner cases but forget to test it

### Test cases

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    
    Stack<Node> stack = new Stack<Node>();
    
    // insert one Node into stack
    private void insert(Node root) {
        stack.push(root);
        while (stack.peek().left != null)
            stack.push(stack.peek().left);
    }
    
    // remove one node
    private Node remove() {
        Node tmp = stack.pop();
        if (tmp.right != null)
            insert(tmp.right);
        return tmp;
    }
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = null, tail = null;
        insert(root);
        while (!stack.isEmpty()) {
            Node tmp = remove();
            if (head == null)
                head = tmp;
            if (tail != null) {
                tail.right = tmp;
                tmp.left = tail;
            }
            tail = tmp;
        }
        tail.right = head;
        head.left = tail;
        
        return head;
    }
}

class Solution {
    Node head = null, tail = null;
    
    private void buildList(Node root) {
        if (root.left != null) buildList(root.left);
        
        if (head == null) head = root;
        if (tail != null) tail.right = root;
        root.left = tail;
        tail = root;
        
        if (root.right != null) buildList(root.right);
    }
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        buildList(root);
        tail.right = head;
        head.left = tail;
        
        return head;
    }
}