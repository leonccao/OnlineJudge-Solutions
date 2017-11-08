class Solution {
public:
    int trap(vector<int>& height) {
        int high = 0;
        vector<int> water;
        for (int i = 0; i < height.size(); i ++) {
            water.push_back(high);
            high = max(high, height[i]);
        }
        
        high = 0;
        for (int i = height.size() - 1; i >= 0; i --) {
            water[i] = min(water[i], high);
            high = max(high, height[i]);
        }
        
        int result = 0;
        for (int i = 0; i < height.size(); i ++)
            result += max(0, water[i] - height[i]);
        return result;
    }
};