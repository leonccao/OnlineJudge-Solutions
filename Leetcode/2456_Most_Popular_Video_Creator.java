class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Integer> maxViewMap = new HashMap<>();
        int n = creators.length;
        
        List<List<String>> ans = new ArrayList<>();
        int maxSum = 0;
        for (int i = 0; i < n; i ++) {
            int count = countMap.getOrDefault(creators[i], 0);
            count += views[i];
            countMap.put(creators[i], count);
            
            int maxViewIdx = maxViewMap.getOrDefault(creators[i], i);
            if (views[maxViewIdx] < views[i] || 
               (views[maxViewIdx] == views[i] && ids[maxViewIdx].compareTo(ids[i]) > 0)) {
                maxViewIdx = i;
            }
            maxViewMap.put(creators[i], maxViewIdx);
            
            if (count > maxSum) {
                maxSum = count;
                ans.clear();
            }
            if (count == maxSum) {
                List<String> cur = new ArrayList<>();
                cur.add(creators[i]);
                cur.add(ids[maxViewIdx]);
                ans.add(cur);
            }
        }
        return ans;
    }
}