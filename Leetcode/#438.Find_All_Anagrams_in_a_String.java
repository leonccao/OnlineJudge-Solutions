class Solution {
    
    private boolean check(int[] head, int[] tail, int[] target) {
        for (int i = 0; i < 26; i ++)
            if (head[i] - tail[i] != target[i])
                return false;
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<Integer>();
        if (s.length() < p.length()) return ans;
        
        // build target array from string p
        int[] target = new int[26];
        for (char ch : p.toCharArray()) {
            ++ target[ch - 'a'];
        }
        
        // check position 0
        int[] head = new int[26];
        int[] tail = new int[26];
        for (int i = 0; i < p.length(); i ++) {
            ++ head[s.charAt(i) - 'a'];
        }
        if (check(head, tail, target)) ans.add(0);
        
        // check other positions
        for (int i = 0; i + p.length() < s.length(); i ++) {
            ++ tail[s.charAt(i) - 'a'];
            ++ head[s.charAt(i + p.length()) - 'a'];
            if (check(head, tail, target)) ans.add(i + 1);
        }
        
        return ans;
    }
}