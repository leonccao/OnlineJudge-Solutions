class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result = 0;
        int lastLimit = 0; 
        int len = brackets.length;
        for (int i = 0; i < len; i++) {
            int limit = brackets[i][0];
            int val = income < limit ? income - lastLimit : limit - lastLimit;
            result += (double)val * brackets[i][1] / 100;
            
            if (income < limit) {
                break;
            }
            
            lastLimit = limit;
        }
        return result;
    }
}