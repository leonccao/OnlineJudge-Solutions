class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head) return head;
        if (k == 0) return head;
        int num = 0;
        ListNode* tmp = head;
        ListNode* tail;
        while (tmp) {
            tail = tmp;
            tmp = tmp->next;
            num ++;
        }
        k = k % num;
        if (k == 0) return head;
        
        int pos = num - k;
        tmp = head;
        while (-- pos) tmp = tmp->next;
        tail->next = head;
        head = tmp->next;
        tmp->next = NULL;
        
        return head;
    }
};