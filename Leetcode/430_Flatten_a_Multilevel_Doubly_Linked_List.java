
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node tail = null;
        Stack<Node> stack = new Stack<Node>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur.next != null)
                stack.push(cur.next);
            if (cur.child != null) {
                stack.push(cur.child);
                cur.child = null;
            }
            if (tail != null) {
                tail.next = cur;
                cur.prev = tail;
            }
            tail = cur;
        }
        return head;
    }
}

class Solution {
    public Node flatten(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.child == null) continue;
            Node tmp = cur.child;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = cur.next;
            if (cur.next != null)
                cur.next.prev = tmp;
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
        }
        return head;
    }
}

// new 
class Solution {
    public Node flatten(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.child != null) {
                Node tmp = null;
                for (tmp = cur.child; tmp.next != null; tmp = tmp.next);
                tmp.next = cur.next;
                if (tmp.next != null) tmp.next.prev = tmp;
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
        }
        return head;
    }
}