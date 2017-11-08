class Solution {
public:
    bool canJump(vector<int>& nums) {
        struct Node {
            int limit;
            int steps;
            Node() {}
            Node(int x, int y) {
                limit = x;
                steps = y;
            }
        };
        
        queue<Node> q;
        Node tmp = Node(0, -1);
        q.push(tmp);
        for (int i = 0; i < nums.size(); i ++) {
            while (!q.empty() && q.front().limit < i) q.pop();
            if (q.empty()) return false;
            tmp.steps = q.front().steps + 1;
            tmp.limit = i + nums[i]; 
            if (q.back().limit < tmp.limit)
                q.push(tmp);
        }
        return true;
    }
};