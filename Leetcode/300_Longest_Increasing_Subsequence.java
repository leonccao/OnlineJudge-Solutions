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

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> rec = new ArrayList<Integer>();
        rec.add(Integer.MIN_VALUE);
        for (int num : nums) {
            int l = 0, r = rec.size();
            while (l < r - 1) {
                int mid = l + (r - l) / 2;
                if (rec.get(mid) < num) l = mid;
                else r = mid;
            }
            if (++ l < rec.size()) {
                if (num < rec.get(l))
                    rec.set(l, num);
            } else rec.add(num);
        }
        return rec.size() - 1;
    }
}