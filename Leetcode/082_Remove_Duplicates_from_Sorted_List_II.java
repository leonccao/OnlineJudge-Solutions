/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headN = new ListNode(Integer.MIN_VALUE);
        headN.next = head;
        ListNode now = head, last = null, record = headN;
        while (now != null) {
            if ((last == null || last.val != now.val) && 
                (now.next == null || now.val != now.next.val)) {
                record.next = now;
                record = now;
            }
            last = now;
            now = now.next;
            record.next = null;
        }
        return headN.next;
    }
}