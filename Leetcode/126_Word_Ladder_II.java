class Solution {
    
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    
    public boolean solveLen(Queue<String> queue, String endWord, Set<String> wordDict, Set<String> visited, Set<String> solved) {
        if (queue.size() == 0) return false;
        
        for (String s : queue)
            solved.add(s);
        
        Queue<String> nextq = new LinkedList<String>();
        boolean found = false;
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            
            for (int i = 0; i < cur.length(); i ++) {
                StringBuilder sb = new StringBuilder(cur);
                for (char ch = 'a'; ch < 'z'; ch ++) {
                    sb.setCharAt(i, ch);
                    String st = sb.toString();
                    
                    if (!wordDict.contains(st)) continue;
                    if (st.equals(endWord)) found = true;
                    if (visited.add(st)) nextq.offer(st);
                    
                    if (!solved.contains(st)) {
                        List<String> list = map.containsKey(st) ? map.get(st) : new LinkedList<String>();
                        list.add(cur);
                        map.put(st, list);
                    }
                }
            }        
        }
        return found || solveLen(nextq, endWord, wordDict, visited, solved);
    }
    
    public void buildPath(String cur, String end, List<List<String>> result, List<String> path) {
        
        if (cur.equals(end)) {
            List<String> copy = new LinkedList<String>(path);
            result.add(copy);
            return;
        }
        
        for (String s : map.get(cur)) {
            path.add(0, s);
            buildPath(s, end, result, path);
            path.remove(0);
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<List<String>>();
        List<String> path = new LinkedList<String>();
        path.add(endWord);
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        Set<String> wordDict = new HashSet<String>(wordList);
        Set<String> visited  = new HashSet<String>();
        Set<String> solved   = new HashSet<String>();
        solved.add(beginWord);
        if(!solveLen(queue, endWord, wordDict, visited, solved))
            return result;
        
        buildPath(endWord, beginWord, result, path);
        return result;
    }
}