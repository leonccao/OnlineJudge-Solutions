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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (k == 1) return head;
        
        ListNode *headhead = new ListNode(0);
        vector<ListNode*> match(k);
        headhead->next = head;
        
        int sign =  0;
        match[0] = headhead;
        while (head) {
            sign = (sign + 1) % k;
            
            if (!sign) {
                match[0]->next = head;
                match[0] = match[1];
                match[0]->next = head->next;
                head->next = match[k - 1];
                for (int i = k - 1; i > 1; i --) {
                    match[i]->next = match[i - 1];
                }
                head = match[0];
            } else {
                match[sign] = head;
            }
            
            
            head = head->next;
        }
        
        return headhead->next;
        
    }
};