class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            int target = -nums[i], last = Integer.MIN_VALUE;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                while (j < k && nums[j] == last) j ++;
                last = nums[j];
                while (k > j && nums[j] + nums[k] > target) k --;
                if (j < k && nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                }
            }
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i ++;
        }
        return ans;
    }
}