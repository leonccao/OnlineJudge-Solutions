/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {    
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < G.length; i ++)
            set.add(G[i]);
        int ans = 0;
        boolean last = false;
        for (ListNode tmp = head; tmp != null; tmp = tmp.next) {
            if (!set.contains(tmp.val)) { last = false; continue;}
            if (last == false) { ans ++; last = true; continue;}
            last = true;
        }
        return ans;
    }
}