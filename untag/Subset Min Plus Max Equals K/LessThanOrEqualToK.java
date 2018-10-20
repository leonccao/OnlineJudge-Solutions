import java.util.*;

public class LessThanOrEqualToK {

    private int findSubset(int[] nums, int k) {
        long[] sumPow = new long[nums.length + 2];
        long twoPow = 1;
        sumPow[0] = 0;
        for (int i = 0; i <= nums.length; i ++) {
            sumPow[i + 1] = sumPow[i] + twoPow;
            twoPow <<= 1;
        }

        Arrays.sort(nums);
        
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
        
        int i = -1, ans = 0;
        for (int j = nums.length - 1; j >= 0; j --) {
            while (i + 1 < nums.length && nums[i + 1] + nums[j] <= k) i ++;
            if (i < j)
                ans += (int)(sumPow[j] - sumPow[j - i - 1]);
            else ans += (int)(sumPow[j + 1] - sumPow[j]);
            System.out.println(j + " " + ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        LessThanOrEqualToK sol = new LessThanOrEqualToK();
        int[] nums = {1, 2, 3};
        System.out.println(sol.findSubset(nums, 4));
    }
}
