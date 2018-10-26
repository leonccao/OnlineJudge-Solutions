public class ThirdLargest {

    public int thirdLargest(int[] nums) {
        int a, b, c;
        a = b = c = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > a) {
                c = b; b = a; a = num;
            } else if (num > b) {
                c = b; b = num;
            } else if (num > c) c = num;
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        ThirdLargest sol = new ThirdLargest();
        System.out.println(sol.thirdLargest(nums));
    }
}