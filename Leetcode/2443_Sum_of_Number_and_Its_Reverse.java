class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = num / 2; i <= num; i++) {
            StringBuilder sb = new StringBuilder("" + i);
            sb.reverse();
            int r = Integer.valueOf(sb.toString());
            if (i + r == num) {
                return true;
            }
        }
        return false;
    }
}