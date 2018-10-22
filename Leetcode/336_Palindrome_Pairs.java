class Solution {
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i ++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i ++)
            map.put(words[i], i);
        
        for (int i = 0; i < words.length; i ++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j ++) {
                StringBuilder sb;
                sb = new StringBuilder(word.substring(0, j));
                String s = sb.reverse().toString();
                sb = new StringBuilder(word.substring(j));
                String t = sb.reverse().toString();
                
                if (s.length() >= 0 && isPalindrome(t) && 
                    map.containsKey(s) && map.get(s) != i) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(i);
                        tmp.add(map.get(s));
                        ans.add(tmp);
                    }
                if (t.length() >= 0 && isPalindrome(s) && s.length() > 0 && 
                    map.containsKey(t) && map.get(t) != i) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(map.get(t));
                        tmp.add(i);
                        ans.add(tmp);
                    }
            }
        }
        return ans;
    }
}