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
        if (head == null) return head;
        ListNode last, now;
        last = head;
        now = head.next;
        while (now != null) {
            if (now.val != last.val) {
                last.next = now;
                last = now;
            }
            now = now.next;
        }
        last.next = null;
        return head;
    }
}