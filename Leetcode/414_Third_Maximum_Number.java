class Solution {
    public int thirdMax(int[] nums) {
        long m1, m2, m3;
        m1 = m2 = m3 = (long)Integer.MIN_VALUE - 1;
        for (int num : nums) {
            if (num == m1 || num == m2 || num == m3)
                continue;
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = (long)num;
            } else if (num > m2) {
                m3 = m2;
                m2 = (long)num;
            } else if (num > m3) {
                m3 = (long)num;
            }
        }
        if (m3 != (long)Integer.MIN_VALUE - 1)
            return (int)m3;
        else return (int)m1;
    }
}