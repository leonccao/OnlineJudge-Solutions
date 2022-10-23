class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                count++;
                set.add(num);
            }
            StringBuilder sb = new StringBuilder("" + num);
            sb.reverse();
            int numr = Integer.valueOf(sb.toString());
            if (!set.contains(numr)) {
                count++;
                set.add(numr);
            }
        }
        return count;
    }
}