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