class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Set> map = new HashMap<String, Set>();
        for (String word : wordDict) {
            int[] pre = new int[word.length()];
            int j = -1;
            pre[0] = -1;
            for (int i = 1; i < word.length(); i ++) {
                while (j > -1 && word.charAt(j + 1) != word.charAt(i)) j = pre[j];
                if (word.charAt(j + 1) == word.charAt(i)) j ++;
                pre[i] = j;
            }
            
            Set<Integer> set = new HashSet<Integer>();
            j = -1;
            for (int i = 0; i < s.length(); i ++) {
                while (j > -1 && s.charAt(i) != word.charAt(j + 1)) j = pre[j];
                if (s.charAt(i) == word.charAt(j + 1)) j ++;
                if (j == word.length() - 1) {
                    set.add(i + 1);
                    j = pre[j];
                }
            }
            map.put(word, set);
        }
        
        boolean[] match = new boolean[s.length() + 1];
        match[0] = true;
        for (int i = 1; i <= s.length(); i ++) {
            for (String word : wordDict)
                if (map.get(word).contains(i))
                    if (match[i - word.length()]) {
                        match[i] = true;
                        break;
                    }
        }
        return match[s.length()];
    }
}