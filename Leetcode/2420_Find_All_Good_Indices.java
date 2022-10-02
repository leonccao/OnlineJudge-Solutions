class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                count = 1;
            } else {
                count++;
            }
            left[i] = count;
        }
        
        count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || nums[i] > nums[i + 1]) {
                count = 1;
            } else {
                count++;
            }
            right[i] = count;
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; i ++) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                ans.add(i);
            }
        }
        return ans;
    }
}