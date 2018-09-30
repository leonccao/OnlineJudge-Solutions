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

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) i ++;
            else if (nums1[i] > nums2[j]) j ++;
            else {
                //if (ans.isEmpty() || nums1[i] != ans.get(ans.size() - 1))
                ans.add(nums1[i]);
                i ++; j ++;
            }
        }
        int[] rtn = new int[ans.size()];
        for (i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
}