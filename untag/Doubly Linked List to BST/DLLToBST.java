public class DLLToBST {

    class Node {
        int val;
        Node prev, next;
        Node(int val) {
            this.val = val;
        }
        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node cur;

    DLLToBST() {}

    private Node build(int count) {
        if (count == 0) return null;
        Node left = build(count / 2);
        Node root = cur;
        root.prev = left;
        cur = cur.next;
        root.next = build(count - count / 2 - 1);
        return root;
    }

    public Node DLL2BST(Node head) {
        if (head == null) return null;

        int count = 1;
        cur = head.next;
        while (cur != head) {
            count ++;
            cur = cur.next;
        }
        cur = head;
        System.out.println("count: " + count);
        return build(count);
    }

    private void test() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.prev = three;
        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;
        three.next = one;

        Node root = DLL2BST(one);
        System.out.println(root.val);
        System.out.println(root.prev.val);
        System.out.println(root.next.val);
    }

    public static void main(String[] args) {
        DLLToBST d2b = new DLLToBST();
        d2b.test();
    }
}