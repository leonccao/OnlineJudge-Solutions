class Solution {
    public List<String> DFS(String left, List<String> wordDict, Map<String, List> ansRec) {
        if (ansRec.containsKey(left))
            return ansRec.get(left);
        
        List<String> answer = new LinkedList<String>();
        if (left.length() == 0) {
            answer.add("");
            return answer;
        }
        
        for (String word : wordDict) {
            if (!left.startsWith(word)) continue;
            List<String> ansTmp = DFS(left.substring(word.length(), left.length()), wordDict, ansRec);
            for (String ans : ansTmp) {
                answer.add(word + (ans.length() == 0 ? "" : " ") + ans);
            }
        }
        ansRec.put(left, answer);
        return answer;
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, List>());
    }
}