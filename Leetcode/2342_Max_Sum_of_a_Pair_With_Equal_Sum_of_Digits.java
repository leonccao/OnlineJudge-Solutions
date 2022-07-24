/*
    You cannot use Arrays.sort with lambda on int array
    They have to be Integer array
*/
class Solution {
    public int maximumSum(int[] nums) {
        Integer[] numsInt = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsInt[i] = nums[i];
        }
        
        Arrays.sort(numsInt, 
            (Integer a, Integer b) -> {
                int dsa = getDigitSum(a);
                int dsb = getDigitSum(b);
                return dsa == dsb ? a - b : dsa - dsb;
            });
        
        int result = -1;
        for (int i = 0; i < numsInt.length - 1; i++) {
            if (getDigitSum(numsInt[i]) == getDigitSum(numsInt[i + 1])) {
                result = Math.max(result, numsInt[i] + numsInt[i + 1]);
            }
        }
        return result;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}