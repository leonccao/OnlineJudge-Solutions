class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<String>();
        for (String tmp : banned)
            ban.add(tmp);
        
        paragraph = paragraph.trim().toLowerCase();
        String[] words = paragraph.split("\\s+");
        for (int i = 0; i < words.length; i ++) {
            StringBuilder word = new StringBuilder(words[i]);
            char ch = word.charAt(word.length() - 1);
            if (ch < 'a' || ch > 'z')
                word.deleteCharAt(word.length() - 1);
            words[i] = word.toString();
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (ban.contains(word)) continue;
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        int answer = 0;
        String keyWord = "";
        for (String word : map.keySet()) {
            if (map.get(word) > answer) {
                answer = map.get(word);
                keyWord = word;
            }
        }
        return keyWord;
    }
}