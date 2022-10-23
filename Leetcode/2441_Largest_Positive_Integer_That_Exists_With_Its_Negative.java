class Solution {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = -1;
        for (int num : nums) {
            if (num <= result) {
                continue;
            }
            if (set.contains(-num)) {
                result = num;
            }
        }
        return result;
    }
}