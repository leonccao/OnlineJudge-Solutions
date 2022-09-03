// Stack
class Solution {    
    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*' && 
                !stack.isEmpty() && stack.peek() != '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}

// Double linked list
class Solution {
    
    private class Node {
        char ch;
        Node prev, next;
        Node(char ch, Node prev) {
            this.ch = ch;
            this.prev = prev;
            if (prev != null) {
                prev.next = this;
            }
        }
    }
    
    public String removeStars(String s) {
        Node head = new Node('$', null);
        Node last = head;
        for (char ch : s.toCharArray()) {
            Node cur = new Node(ch, last);
            last = cur;
        }
        for (Node cur = head.next; cur != null; cur = cur.next) {
            if (cur.ch == '*' && cur.prev != head && cur.prev.ch != '*') {
                Node pprev = cur.prev.prev;
                Node next = cur.next;
                pprev.next = next;
                if (next != null) {
                    next.prev = pprev;
                }
                cur = pprev;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Node cur = head.next; cur != null; cur = cur.next) {
            sb.append(cur.ch);
        }
        return sb.toString();
    }
}