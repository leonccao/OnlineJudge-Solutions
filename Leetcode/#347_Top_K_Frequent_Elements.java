class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        
        List<Integer>[] rank = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int tmp = map.get(key);
            if (rank[tmp] == null)
                rank[tmp] = new LinkedList<Integer>();
            rank[tmp].add(key);
        }
        
        List<Integer> ans = new LinkedList<Integer>();
        OUTER_LOOP:
        for (int i = nums.length; i > 0; i --) {
            List<Integer> list = rank[i];
            if (list == null) continue;
            for (int num : list) {
                ans.add(num);
                k --;
                if (k == 0) break OUTER_LOOP;
            }
        }
        return ans;
    }
}