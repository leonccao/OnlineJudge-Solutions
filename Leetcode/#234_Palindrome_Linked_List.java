/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
            ListNode tmpNode = head;
            int len = 0;
            while (tmpNode != null) {
                tmpNode = tmpNode.next;
                len ++;
            }
            int mid = (len + 1) / 2;
            tmpNode = head;
            for (int i = 0; i < mid; i ++)
                tmpNode = tmpNode.next;
        
            ListNode prev = null;
            ListNode next = null;
            ListNode now  = tmpNode;
            while (now != null) {
                next = now.next;
                now.next = prev;
                prev = now;
                now = next;
            }
        
            while (prev != null) {
                if (head.val != prev.val)
                    return false;
                head = head.next;
                prev = prev.next;
            }
            return true;
    }
}