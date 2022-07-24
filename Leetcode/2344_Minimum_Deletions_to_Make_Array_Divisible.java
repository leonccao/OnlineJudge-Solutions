class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int gcd = findGCD(numsDivide);
        //System.out.println(gcd);
        for (int i = 0; i < nums.length; i++) {
            if (gcd % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
 
    static int findGCD(int arr[])
    {
        int result = arr[0];
        for (int element: arr){
            result = gcd(result, element);
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }
}