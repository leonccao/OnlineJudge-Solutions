class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i ++) {
            for (int j = i + 1; j < nums.length - 2; j ++) {
                int left = j + 1, right = nums.length - 1;
                int last = Integer.MIN_VALUE;
                int want = target - nums[i] - nums[j];
                while (left < right) {
                    while (left < right && nums[left] == last) left ++;
                    last = nums[left];
                    while (left < right && nums[left] + nums[right] > want) right --;
                    if (left < right && nums[left] + nums[right] == want) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) j ++;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) i ++;
        }
        return ans;
    }
}

class Solution {
    class Pair {
        int l, r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i ++)
        for (int j = i + 1; j < nums.length; j ++) {
            int sum = nums[i] + nums[j];
            int want = target - sum;
            if (map.containsKey(want)) {
                List<Pair> pairs = map.get(want);
                for (Pair pair : pairs) {
                    if (pair.r >= i) continue;
                    List<Integer> tmp = Arrays.asList(nums[pair.l], nums[pair.r], nums[i], nums[j]);
                    Collections.sort(tmp);
                    set.add(tmp);
                }
            }
            List<Pair> tmp = map.getOrDefault(sum, new ArrayList<Pair>());
            tmp.add(new Pair(i, j));
            map.put(sum, tmp);
        }
        return new ArrayList<List<Integer>>(set);
    }
}