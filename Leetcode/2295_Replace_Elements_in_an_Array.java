class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int from = operation[0];
            int to = operation[1];
            int index = map.get(from);
            nums[index] = to;
            map.remove(from);
            map.put(to, index);
        }
        return nums;
    }
}