class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        
        int mod = num % 10;
        for (int i = 1; i <= 10; i++) {
            if (k * i % 10 == mod && k * i <= num) {
                return i;
            }
        }
        return -1;
    }
}