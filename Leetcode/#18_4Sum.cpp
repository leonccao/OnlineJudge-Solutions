class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        
        if (nums.size() < 4) return result;
        
        sort(nums.begin(), nums.end());
        
        for (int i = 0; i + 3 < nums.size(); i ++) {
            for (int j = nums.size() - 1; j > i + 2; j --) {
                
                int front = i + 1, back = j - 1;
                
                while (front < back) {
                    int nf = nums[front];
                    int nb = nums[back];
                    int tmp = nums[front] + nums[back] + nums[i] + nums[j];
                    
                    if (tmp < target) front ++;
                    else if (tmp > target) back --;
                    else {
                        vector<int> quadruplet(4, 0);
                        quadruplet[0] = nums[i];
                        quadruplet[1] = nums[front];
                        quadruplet[2] = nums[back];
                        quadruplet[3] = nums[j];
                        result.push_back(quadruplet);
                        while (nums[front] == nf && front < back) front ++;
                        while (nums[back] == nb && back > front) back --;
                    }
                }
                while (j > i + 2 && nums[j - 1] == nums[j]) j --;
            }
            
            while (i + 3 < nums.size() && nums[i + 1] == nums[i]) i ++;
        }
        
        return result;
    }
};