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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (!l1 && !l2) return l1;
        
        ListNode *head = NULL, *tail = NULL;
        while (l1 && l2) {
            int tmp;
            if (l1->val < l2->val) {
                tmp = l1->val;
                l1 = l1->next;
            } else {
                tmp = l2->val;
                l2 = l2->next;
            }
            
            if (head) {
                ListNode *pointer = new ListNode(tmp);
                tail->next = pointer;
                tail = pointer;
            } else {
                head = new ListNode(tmp);
                tail = head;
            }
        }
        
        while (l1) {
            int tmp = l1->val;
            l1 = l1->next;
            if (head) {
                ListNode *pointer = new ListNode(tmp);
                tail->next = pointer;
                tail = pointer;
            } else {
                head = new ListNode(tmp);
                tail = head;
            }
        }
        
        while (l2) {
            int tmp = l2->val;
            l2 = l2->next;
            if (head) {
                ListNode *pointer = new ListNode(tmp);
                tail->next = pointer;
                tail = pointer;
            } else {
                head = new ListNode(tmp);
                tail = head;
            }
        }
        
        return head;
    }
};