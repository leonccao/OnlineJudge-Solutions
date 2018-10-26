/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            }
        );
        for (ListNode list : lists) 
            if (list != null)
                pq.add(list);
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null)
                pq.add(tail.next);
        }
        return head.next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode list : lists) 
            if (list != null) pq.add(list);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;
            if (tail.next != null)
                pq.add(tail.next);
        }
        return head.next;
    }
}