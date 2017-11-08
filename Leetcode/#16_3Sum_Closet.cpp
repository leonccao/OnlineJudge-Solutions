class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        
        int gap = INT_MAX, result;
        
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i + 2 < nums.size(); i ++) {
            
            int front = i + 1, back = nums.size() - 1;
            
            int breaksign = false;
            
            while (front < back) {
                int tmp = nums[front] + nums[back] + nums[i];
                
                if (abs(tmp - target) < gap) {
                    gap = abs(tmp - target);
                    result = tmp;
                }
                
                if (tmp < target) front ++;
                if (tmp > target) back --;
                if (tmp == target) {breaksign = true; break;}
            }
            if (breaksign) break;
        }
        
        return result;
    }
};