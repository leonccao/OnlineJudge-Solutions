/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        for (ListNode tmp = l1; tmp != null; tmp = tmp.next) s1.push(tmp);
        for (ListNode tmp = l2; tmp != null; tmp = tmp.next) s2.push(tmp);
        int carry = 0;
        ListNode prev = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int tmp = carry;
            if (!s1.isEmpty()) tmp += s1.pop().val;
            if (!s2.isEmpty()) tmp += s2.pop().val;
            carry = tmp / 10;
            ListNode cur = new ListNode(tmp % 10);
            cur.next = prev;
            prev = cur;
        }
        if (carry > 0) {
            ListNode cur = new ListNode(carry);
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}