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

/*
Bugs:
1. `List<Integer> ans = new ArrayList<Integer>();`
2. `l = mid + 1;` -> `int mid = (l + r) / 2 - 1;`
3. return value
4. binarySearch nums2[] maybe null
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i ++) {
            if (binarySearch(nums2, nums1[i]))
                ans.add(nums1[i]);
            while (i + 1 < nums1.length && nums1[i + 1] == nums1[i]) i ++;
        }
        
        int[] rtn = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        if (nums.length == 0) return false;
        int l = 0, r = nums.length;
        while (l < r - 1) {
            int mid = (l + r) / 2 - 1;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return nums[l] == target;
    }
}