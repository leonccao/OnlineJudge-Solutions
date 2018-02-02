/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode last = head;
        ListNode tmp = null;
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            tmp = next;
            next = tmp.next;
            tmp.next = last;
            last = tmp;
        }
        return last;        
    }
}