class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum & 1) {
            return false;
        }
        sum /= 2;
        
        bitset<10001> f (1);
        for (const auto num : nums) {
            f |= f << num;
        }
        return f[sum];
    }
};