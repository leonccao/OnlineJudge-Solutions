/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        for (RandomListNode iter = head; iter != null; iter = iter.next.next) {
            RandomListNode dup = new RandomListNode(iter.label);
            dup.next = iter.next;
            iter.next = dup;
        }
        for (RandomListNode iter = head; iter != null; iter = iter.next.next)
            iter.next.random = iter.random != null ? iter.random.next : null;
        RandomListNode dupHead = head.next;
        for (RandomListNode iter = head; iter != null; iter = iter.next) {
            RandomListNode tmp = iter.next.next;
            iter.next.next = iter.next.next != null ? iter.next.next.next : null;
            iter.next = tmp;
        }
        return dupHead;
    }
}