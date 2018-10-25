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

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int num : nums2)
            if (map.getOrDefault(num, 0) > 0) {
                ans.add(num);
                map.put(num, map.get(num) - 1);
            }
        int[] rtn = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums1.length && j < nums2.length)
            if (nums1[i] < nums2[j]) i ++;
            else if (nums1[i] > nums2[j]) j ++;
            else {
                ans.add(nums1[i]);
                i ++; j ++;
            }
        
        int[] rtn = new int[ans.size()];
        for (i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
}

// border + BinarySearch
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int floor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int num : nums1) {
            int tmp = binarySearch(nums2, num, floor);
            if (tmp > -1) {
                ans.add(num);
                floor = tmp + 1;
            }
        }
        int[] rtn = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
    
    private int binarySearch(int[] nums, int target, int floor) {
        if (floor >= nums.length) return -1;
        int l = floor, r = nums.length;
        while (l < r - 1) {
            int mid = l + (r - l) / 2 - 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid + 1;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}