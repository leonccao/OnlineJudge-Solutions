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

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxn = 0;
        for (int num : nums) {
            int tmp = map.getOrDefault(num, 0) + 1;
            maxn = Math.max(maxn, tmp);
            map.put(num, tmp);
        }
        
        List<Integer>[] bucket = new List[maxn + 1];
        for (int i = 0; i <= maxn; i ++)
            bucket[i] = new ArrayList<Integer>();
        for (int key : map.keySet())
            bucket[map.get(key)].add(key);
        
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = maxn; i > 0; i --)
            for (int j = 0; j < bucket[i].size(); j ++) {
                ans.add(bucket[i].get(j));
                if (-- k == 0) return ans;
            }
        return ans;
    }
}