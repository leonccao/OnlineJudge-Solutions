/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode firstHead  = new ListNode(-1);
        ListNode secondHead = new ListNode(-1);
        ListNode firstTail  = firstHead;
        ListNode secondTail = secondHead;
        
        while (head != null) {
            if (head.val < x) {
                firstTail.next = head;
                firstTail = head;
            } else {
                secondTail.next = head;
                secondTail = head;
            }
            head = head.next;
        }
        firstTail.next  = secondHead.next;
        secondTail.next = null;
        return firstHead.next;
    }
}