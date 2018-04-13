/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeSort(ListNode head, int len) {
        if (len == 1) {
            head.next = null;
            return head;
        }
        
        int mid = len / 2;
        ListNode head2 = head;
        for (int i = 0; i < mid; i ++, head2 = head2.next);
        head = mergeSort(head, mid);
        head2 = mergeSort(head2, len - mid);
        ListNode pointer = head;
        ListNode pointer2 = head2;
        ListNode fakeHead = new ListNode(-1);
        ListNode fakePointer = fakeHead;
        while (pointer != null || pointer2 != null) {
            if (pointer2 == null || (pointer != null && pointer.val < pointer2.val)) {
                fakePointer.next = pointer;
                fakePointer = fakePointer.next;
                pointer = pointer.next;
            } else {
                fakePointer.next = pointer2;
                fakePointer = fakePointer.next;
                pointer2 = pointer2.next;
            }
        }
        return fakeHead.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int len = 0;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next, len ++);
        return mergeSort(head, len);
    }
}