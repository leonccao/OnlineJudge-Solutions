class Solution {
    public boolean digitCount(String num) {
        int[] count = new int[10];
        for (char ch : num.toCharArray()) {
            count[ch - '0']++;
        }
        
        int index = 0;
        for (char ch : num.toCharArray()) {
            int cntDigit = ch - '0';
            if (cntDigit != count[index]) {
                return false;
            }
            index++;
        }
        return true;
    }
}