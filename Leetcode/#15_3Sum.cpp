class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> result;
        
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i + 2 < nums.size(); i ++) {
            
            int front = i + 1, back = nums.size() - 1;
            
            while (front < back) {
                int nf = nums[front];
                int nb = nums[back];
                int tmp = nums[front] + nums[back];
                
                if (tmp + nums[i] < 0) front ++;
                else if (tmp + nums[i] > 0) back --;
                else {
                    vector<int> triplet(3, 0);
                    triplet[0] = nums[front];
                    triplet[1] = nums[i];
                    triplet[2] = nums[back];
                    result.push_back(triplet);
                    while (nums[front] == nf && front < back) front ++;
                    while (nums[back] == nb && back > front) back --;
                }
            }
            
            while (i + 3 < nums.size() && nums[i + 1] == nums[i]) i ++;
        }
        
        return result;
    }
};