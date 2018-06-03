class Solution {
    public int longestMountain(int[] A) {
        int[] left = new int[A.length];
        for (int i = 1; i < A.length; i ++)
            if (A[i] > A[i - 1])
                left[i] = left[i - 1] + 1;
        
        int[] right = new int[A.length];
        for (int i = A.length - 2; i >= 0; i --)
            if (A[i] > A[i + 1])
                right[i] = right[i + 1] + 1;
        
        int ans = 0;
        for (int i = 0; i < A.length; i ++)
            ans = Math.max(ans, (left[i] > 0 && right[i] > 0) ? left[i] + right[i] + 1 : 1);
        return ans >= 3 ? ans : 0;
    }
}