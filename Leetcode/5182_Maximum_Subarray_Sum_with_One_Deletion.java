class Solution {
    public int maximumSum(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        
        left[0] = 0;
        for (int i = 1; i < arr.length; i ++) {
            left[i] = Math.max(0, left[i - 1] + arr[i - 1]);
        }
        
        right[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i --) {
            right[i] = Math.max(0, right[i + 1] + arr[i + 1]);
        }
        
        int ans = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num == 0) {
                ans = 0;
                break;
            }
        }
        
        for (int i = 0; i < arr.length; i ++) {
            ans = Math.max(ans, arr[i] + left[i] + right[i]);
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i]);
            }
        }
        return ans;
    }
}