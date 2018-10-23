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
        return copyOneSpace(head);
    }
    
    private RandomListNode copyOneSpace(RandomListNode head) {
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next.next) {
            RandomListNode cur = new RandomListNode(tmp.label);
            cur.next = tmp.next;
            tmp.next = cur;
        }
        
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next.next)
            tmp.next.random = tmp.random == null ? null : tmp.random.next;
        
        RandomListNode copyHead = head.next;
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next) {
            RandomListNode cur = tmp.next;
            tmp.next = tmp.next.next;
            cur.next = tmp.next == null ? null : tmp.next.next;
        }
        return copyHead;
    }
    
    private RandomListNode copyNSpace(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next)
            map.put(tmp, new RandomListNode(tmp.label));
        for (RandomListNode tmp = head; tmp != null; tmp = tmp.next) {
            map.get(tmp).next   = map.get(tmp.next  );
            map.get(tmp).random = map.get(tmp.random);
        }
        return map.get(head);
    }
}