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
        ListNode cur = head;
        ListNode next = head.next;
        head.next = null;
        for ( ; next != null; ) {
            ListNode nextTmp = next.next;
            next.next = cur;
            cur = next;
            next = nextTmp;
        }
        return cur;
    }
    
    public ListNode mergeList(ListNode head, ListNode head2) {
        for (ListNode tmp = head, tmp2 = head2; tmp!= null && tmp2 != null; ) {
            System.out.println(tmp.val + " " + tmp2.val);
            ListNode nextTmp = tmp.next;
            tmp.next= tmp2;
            ListNode nextTmp2 = tmp2.next;
            tmp2.next = nextTmp;
            tmp = nextTmp;
            tmp2 = nextTmp2;
        }
        return head;
    }
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        int countDown = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next)
            countDown ++;
        countDown = (countDown + 1) / 2 - 1;
        ListNode head2 = head;
        for ( ; countDown > 0; countDown --)
            head2 = head2.next;
        ListNode tmp = head2.next;
        head2.next = null;
        head2 = reverseList(tmp);
        head = mergeList(head, head2);
    }
}