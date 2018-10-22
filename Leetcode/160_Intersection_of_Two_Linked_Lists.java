/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp = headA;
        while (tmp != null) {
            tmp.val = -tmp.val;
            tmp = tmp.next;
        }
        
        tmp = headB;
        ListNode result = null;
        while (tmp != null) {
            if (tmp.val < 0) {
                result = tmp;
                break;
            }
            tmp = tmp.next;            
        }
        
        tmp = headA;
        while (tmp != null) {
            tmp.val = -tmp.val;
            tmp = tmp.next;
        }
        return result;
    }
}