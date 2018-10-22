class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> nums;
        for (int i = 0; i < n; i ++)
            nums.push_back(i + 1);
        k --;
        while (k --) {            
            int mark = nums.size() - 2;
            while (mark >= 0 && nums[mark] >= nums[mark + 1]) mark --;
            if (mark < 0) break;
            
            int tmp = search(nums, mark + 1, nums.size(), nums[mark]);
            swap(nums[mark], nums[tmp]);
            int mid = (mark + nums.size()) / 2;
            for (int i = mark + 1; i <= mid; i ++) {
                tmp = 2 * mid - i;
                if ((mark + nums.size()) % 2) tmp ++;
                swap(nums[i], nums[tmp]);
            }
        }
        
        string result = "";
        for (int i = 0; i < n; i ++)
            result += '0' + nums[i];
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