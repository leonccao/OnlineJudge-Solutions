class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, -1);
        int ans = 0;
        for (int num : nums) {
            if (map.get(num) != -1) continue;
            int len = 1, next = num + 1;
            while (map.containsKey(next)) {
                if (map.get(next) != -1) {
                    len += map.get(next);
                    break;
                }
                len ++;
                map.put(next, 0);
                next ++;
            }
            map.put(num, len);
            ans = Math.max(ans, len);
        }
        return ans;
    }
}