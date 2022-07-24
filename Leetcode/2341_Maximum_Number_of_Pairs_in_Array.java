class Solution {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        int count = 0;
        while (index < nums.length - 1) {
            if (nums[index] == nums[index + 1]) {
                count++;
                index += 2;
            } else {
                index++;
            }
        }
        int[] result = new int[] {count, nums.length - 2 * count};
        return result;
    }
}