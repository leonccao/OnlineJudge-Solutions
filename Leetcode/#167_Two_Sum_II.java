class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            while (numbers[l] + numbers[r] > target) r --;
            while (numbers[l] + numbers[r] < target) l ++;
            if (numbers[l] + numbers[r] == target) break;
        }
        int[] result = new int[2];
        result[0] = l + 1;
        result[1] = r + 1;
        return result;
    }
}