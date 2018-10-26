public class PositiveSubarraySumEqualsK {

    public int subarrySum(int[] nums, int k) {
        if (k <= 0) return 0;
        int j = 0, sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            while (sum > k) sum -= nums[j ++];
            if (sum == k) ans ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 1, 5, 3};
        PositiveSubarraySumEqualsK sol = new PositiveSubarraySumEqualsK();
        System.out.println(sol.subarrySum(nums, 8));
    }
}