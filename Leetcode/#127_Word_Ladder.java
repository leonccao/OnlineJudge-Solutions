class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<String>(wordList);
        if (!wordDict.contains(endWord)) return 0;
        
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet   = new HashSet<String>();
        Set<String> visited  = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int answer = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            answer ++;
            
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            
            Set<String> tmp = new HashSet<String>();
            for (String s : beginSet)
                for (int i = 0; i < beginWord.length(); i ++) {
                    StringBuilder sb = new StringBuilder(s);
                    for (char c = 'a'; c <= 'z'; c ++) {
                        sb.setCharAt(i, c);
                        String st = sb.toString();
                        if (endSet.contains(st))
                            return answer;
                        if (wordDict.contains(st) && !visited.contains(st)) {
                            tmp.add(st);
                            visited.add(st);
                        }
                    }
                }
            beginSet = tmp;
        }
        return 0;
    }
}