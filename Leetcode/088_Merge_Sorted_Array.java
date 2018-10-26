class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1)
            nums1[k --] = (nums1[i] > nums2[j]) ? nums1[i --] : nums2[j --];
        while (j > -1) nums1[k --] = nums2[j --];
        return;
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0; i --) {
            if (m == 0 || (n > 0 && nums2[n - 1] > nums1[m - 1])) 
                nums1[i] = nums2[-- n];
            else nums1[i] = nums1[-- m];
        }
    }
}