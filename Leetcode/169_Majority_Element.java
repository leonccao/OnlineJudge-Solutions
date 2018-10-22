class Solution {
    public int majorityElement(int[] nums) {
        int maj = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {
                cnt = 1;
                maj = num;
            } else if (num == maj)
                cnt ++;
            else cnt --;
        }
        return maj;
    }
}