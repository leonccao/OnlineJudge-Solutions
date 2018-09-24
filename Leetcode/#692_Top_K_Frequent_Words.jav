/*
### Solution
1. HashMap + PriorityQueue
    - Time complexity: O(n log(n))
    - Space complexity: O(n)
    
### Bugs
1. `String.compareTo(String)`

*/
class Solution {
    class PQ {
        String word;
        int cnt;
        PQ(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<PQ> pq = new PriorityQueue<PQ>(new Comparator<PQ>() {
            @Override
            public int compare(PQ a, PQ b) {
                if (a.cnt != b.cnt)
                    return b.cnt - a.cnt;
                return a.word.compareTo(b.word);
            }
        });
        
        for (String word : map.keySet()) 
            pq.add(new PQ(word, map.get(word)));
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < k; i ++)
            ans.add(pq.poll().word);
        return ans;
    }
}