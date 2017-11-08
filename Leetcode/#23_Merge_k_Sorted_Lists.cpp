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
    struct Node {
      int val;
      int from;
      Node(int x, int y) : val(x), from(y) {}
    };
    
    struct NodeCmp{
        bool operator()(const Node &a, const Node &b){
            return a.val > b.val;
        }
    };

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<Node, vector<Node>, NodeCmp> heap;
        ListNode *head = new ListNode(0);
        ListNode *tail = head;
        
        for (int i = 0; i < lists.size(); i ++) {
            if (lists[i]) {
                heap.push(Node(lists[i]->val, i));
            }
        }
        
        while (!heap.empty()) {
            Node tmp = heap.top();
            heap.pop();
            ListNode *tmpL = new ListNode(tmp.val);
            tail->next = lists[tmp.from];
            tail = tail->next;
            lists[tmp.from] = lists[tmp.from]->next;
            if (lists[tmp.from]) {
                heap.push(Node(lists[tmp.from]->val, tmp.from));
            }
        }
        
        return head->next;
    }
};