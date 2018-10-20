import java.util.*;

public class EqualToK {

    private int findSubset(int[] nums, int k) {
        int[] pow = new int[nums.length + 1];
        pow[0] = 1;
        for (int i = 0; i < nums.length; i ++)
            pow[i + 1] = pow[i] << 1;

        Arrays.sort(nums);
        int j = nums.length - 1, ans = 0;
        for (int i = 0; i <= j; i ++) {
            while (j > i && nums[i] + nums[j] > k) j --;
            if (nums[i] + nums[j] == k) {
                int len = j - i >= 1 ? j - i - 1 : 0;
                ans += pow[len];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EqualToK sol = new EqualToK();
        int[] nums = {1, 2, 3};
        System.out.println(sol.findSubset(nums, 2));
    }
}
