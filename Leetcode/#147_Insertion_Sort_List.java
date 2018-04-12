/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void insertSort(ListNode fakeHead, ListNode cur) {
        ListNode pos = null;
        for (pos = fakeHead; pos.next != null && pos.next.val < cur.val; pos = pos.next);
        cur.next = pos.next;
        pos.next = cur;
    }
    
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        for (ListNode next, cur = head; cur != null; cur = next) {
            next = cur.next;
            insertSort(fakeHead, cur);
        }
        return fakeHead.next;
    }
}