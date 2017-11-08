class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0, r = height.size() - 1;
        int maxn = 0;
        while (l < r) {
            int minh = min(height[l], height[r]);
            maxn = max(maxn, minh * (r - l));
            while (height[l] <= minh && l < r) l ++;
            while (height[r] <= minh && l < r) r --;
        }
        return maxn;
    }
};