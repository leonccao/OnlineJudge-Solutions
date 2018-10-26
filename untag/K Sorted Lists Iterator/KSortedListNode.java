import java.math.*;
import java.util.*;

public class KSortedListNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class KListIterator {

        PriorityQueue<ListNode> pq;

        public KListIterator(ListNode[] lists) {
            pq = new PriorityQueue<>(new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            });
            for (ListNode list : lists)
                if (list != null)
                    pq.add(list);
        }

        public boolean hasNext() {
            return !pq.isEmpty();
        }

        public int next() {
            ListNode cur = pq.poll();
            if (cur.next != null)
                pq.add(cur.next);
            return cur.val;
        }

    }

    public void test() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(5);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        ListNode n3 = new ListNode(2);
        n3.next = new ListNode(6);
        ListNode[] lists = {n1, n2, n3};

        KListIterator iterator = new KListIterator(lists);
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        KSortedListNode sol = new KSortedListNode();
        sol.test();
    }
}