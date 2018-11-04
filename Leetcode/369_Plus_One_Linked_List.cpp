class Solution {
private:
    int helper(ListNode* head) {
        if (!head) return 1;
        if (helper(head->next) > 0)
            head->val += 1;
        if (head->val > 9) {
            head->val %= 10;
            return 1;
        }
        return 0;
    }
    
public:
    ListNode* plusOne(ListNode* head) {
        if (!head) return NULL;
        if (helper(head) > 0) {
            ListNode* newHead = new ListNode(1);
            newHead->next = head;
            head = newHead;
        }
        return head;
    }
};