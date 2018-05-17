class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.MIN_VALUE);
        int ans = 0;
        for (int num : nums) {
            int l = 0, r = list.size();
            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (list.get(mid) < num)
                    l = mid;
                else r = mid;
            }
            int tmp = l + 1;
            if (tmp > ans) {
                ans = tmp;
                list.add(num);
            } else if (list.get(tmp) > num)
                list.set(tmp, num);
        }
        return ans;
    }
}