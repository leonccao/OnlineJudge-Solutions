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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int len1(0), len2(0);
        ListNode *tmp1 = l1;
        while (tmp1) {
            len1 ++;
            tmp1 = tmp1->next;
        }
        ListNode *tmp2 = l2;
        while (tmp2) {
            len2 ++;
            tmp2 = tmp2->next;
        }
        
        ListNode *result;
        if (len1 >= len2) {
            tmp1 = l1;
            tmp2 = l2;
            result = l1;
        } else {
            tmp1 = l2;
            tmp2 = l1;
            result = l2;
        }
        int carry = 0;
        while (true) {
            if (tmp2) tmp1->val = tmp1->val + tmp2->val + carry;
            else tmp1->val = tmp1->val + carry;
            if (tmp1->val > 9) {
                carry = 1;
                tmp1->val -= 10;
            } else carry = 0;
            if (!tmp1->next) break;
            tmp1 = tmp1->next;
            if (tmp2) tmp2 = tmp2->next;
        }
        if (carry) {
            ListNode* carry_bit = new ListNode(1);
            tmp1->next = carry_bit;
        }
        
        return result;
    }
};