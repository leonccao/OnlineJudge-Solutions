/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead  = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddTail  = oddHead;
        ListNode evenTail = evenHead;
        
        int cnt = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            cnt ++;
            if (cnt % 2 != 0) {
                oddTail.next = tmp;
                oddTail = tmp;
            } else {
                evenTail.next = tmp;
                evenTail = tmp;
            }
        }
        
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;
    }
}