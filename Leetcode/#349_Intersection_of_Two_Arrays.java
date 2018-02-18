class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hash  = new HashSet<Integer>();
        Set<Integer> inter = new HashSet<Integer>();
        for (int num : nums1)
            hash.add(num);
        for (int num : nums2)
            if (hash.contains(num))
                inter.add(num);
        int[] ans = new int[inter.size()];
        int i = 0;
        for (int num : inter)
            ans[i ++] = num;
        return ans;
    }
}