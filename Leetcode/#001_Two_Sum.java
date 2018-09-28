class Solution {
    class Num {
        int val, index;
        Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public int[] twoSum(int[] nums, int target) {
        Num[] numbers = new Num[nums.length];
        for (int i = 0; i < nums.length; i ++)
            numbers[i] = new Num(nums[i], i);
        Arrays.sort(numbers, new Comparator<Num>(){
            @Override
            public int compare(Num a, Num b) {
                return a.val - b.val;
            }
        });
        
        int j = numbers.length - 1;
        for (int i = 0; i < j; i ++) {
            while (i < j && numbers[i].val + numbers[j].val > target) j --;
            if (numbers[i].val + numbers[j].val == target) {
                int[] ans = {numbers[i].index, numbers[j].index};
                return ans;
            }
        }
        return null;
    }
}