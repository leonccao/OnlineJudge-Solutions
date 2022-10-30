class Solution {
    public int averageValue(int[] nums) {
        int sum = 0, cnt = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                cnt++;
                sum += num;
            }
        }
        return cnt > 0 ? sum / cnt : 0;
    }
}