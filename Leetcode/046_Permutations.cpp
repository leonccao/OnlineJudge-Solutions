class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;
        result.push_back(nums);
        while (true) {            
            int mark = nums.size() - 2;
            while (mark >= 0 && nums[mark] >= nums[mark + 1]) mark --;
            if (mark < 0) break;
            
            int tmp = search(nums, mark + 1, nums.size(), nums[mark]);
            swap(nums[mark], nums[tmp]);
            int mid = (mark + nums.size()) / 2;
            cout << mark << ' ' << mid << endl;
            for (int i = mark + 1; i <= mid; i ++) {
                tmp = 2 * mid - i;
                if ((mark + nums.size()) % 2) tmp ++;
                swap(nums[i], nums[tmp]);
            }
            result.push_back(nums);
        }
        return result;
    }
    
    int search(vector<int>& nums, int l, int r, int target) {
        while (l < r - 1) {
            int mid = (l + r) / 2;
            if (nums[mid] > target)
                l = mid;
            else r = mid;
        }
        return l;
    }
};