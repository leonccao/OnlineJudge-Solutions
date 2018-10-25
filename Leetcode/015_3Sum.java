class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            int target = -nums[i], last = Integer.MIN_VALUE;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                while (j < k && nums[j] == last) j ++;
                last = nums[j];
                while (k > j && nums[j] + nums[k] > target) k --;
                if (j < k && nums[j] + nums[k] == target) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    ans.add(tmp);
                }
            }
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i ++;
        }
        return ans;
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i], last = Integer.MIN_VALUE;
            while (j < k) {
                while (j < k && nums[j] == last) j ++;
                last = nums[j];
                while (j < k && nums[j] + nums[k] > target) k --;
                if (j < k && nums[j] + nums[k] == target)
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i ++;
        }
        return ans;
    }
}

// O(n ^ 2) HashMap
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], map.get(nums[i]) - 1);
            if (map.get(nums[i]) == 0)
                map.remove(nums[i]);
            for (int j = 0; j < i; j ++) {
                int tar = - nums[i] - nums[j];
                if (map.containsKey(tar)) {
                    List<Integer> tmp = Arrays.asList(nums[j], nums[i], tar);
                    Collections.sort(tmp);
                    ans.add(tmp);
                }
            }
        }
        List<List<Integer>> rtn = new ArrayList<>();
        rtn.addAll(ans);
        return rtn;
    }
}