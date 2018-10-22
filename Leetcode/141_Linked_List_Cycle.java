/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode now = head;
        while (now != null) {
            if (now.val == 0)
                return true;
            now.val = 0;
            now = now.next;
        }
        return false;
    }
}
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast)
                return true;
        }
        return false;
    }
}