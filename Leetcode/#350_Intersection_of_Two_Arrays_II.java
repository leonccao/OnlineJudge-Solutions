class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hash  = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : nums1)
            if (!hash.containsKey(num))
                hash.put(num, 1);
            else hash.replace(num, hash.get(num) + 1);
        for (int num : nums2)
            if (hash.containsKey(num) && hash.get(num) > 0) {
                list.add(num);
                hash.replace(num, hash.get(num) - 1);
            }
        int[] ans = new int[list.size()];
        int i = 0;
        for (int num : list)
            ans[i ++] = num;
        return ans;       
    }
}