class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i ++) {
            for (int j = i + 1; j < nums.length - 2; j ++) {
                int left = j + 1, right = nums.length - 1;
                int last = Integer.MIN_VALUE;
                int want = target - nums[i] - nums[j];
                while (left < right) {
                    while (left < right && nums[left] == last) left ++;
                    last = nums[left];
                    while (left < right && nums[left] + nums[right] > want) right --;
                    if (left < right && nums[left] + nums[right] == want) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j ++;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i ++;
        }
        return ans;
    }
}