/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    if (a == null) return null;
	    
	    ListNode slow = a;
	    ListNode fast = a.next;
	    while (fast != null) {
	        if (fast.val != slow.val) {
	            slow.next = fast;
	            slow = slow.next;
	        }
	        fast = fast.next;
	    }
	    slow.next = null;
	    return a;
	}
}
