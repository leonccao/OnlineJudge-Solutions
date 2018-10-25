class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int mul = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            mul *= nums[i];
            ans[i + 1] *= mul;
        }
        mul = 1;
        for (int i = nums.length - 1; i > 0; i --) {
            mul *= nums[i];
            ans[i - 1] *= mul;
        }
        return ans;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            ans[i] = sum;
            sum *= nums[i];
        }
        sum = 1;
        for (int i = nums.length - 1;i >= 0; i --) {
            ans[i] *= sum;
            sum *= nums[i];
        }
        return ans;
    }
}

// Use division and zero judge
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1, count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) count ++;
            else sum *= nums[i];
        }
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = nums[i] == 0 ?
                (count > 1 ? 0 : sum) :
                (count > 0 ? 0 : sum / nums[i]);
        }
        return nums;
    }
}