/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *pointer = head;
        int length = 0;
        while (pointer) {
            length ++;
            pointer = pointer->next;
        }
        
        int pos = length + 1 - n;
        if (pos == 1) return head = head->next;
        pointer = head;
        
        int tmp = 0;
        while (pointer) {
            tmp ++;
            if (tmp == pos - 1) {
                pointer->next = pointer->next->next;
                break;
            }
            pointer = pointer->next;
        }
        return head;
    }
};