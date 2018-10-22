/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode last, now;
        last = start;
        now = head;
        
        while (now != null) {
            if (now.val == val)
                last.next = now.next;
            else last = now;
            now = now.next;
        }
        
        return start.next;
    }
}