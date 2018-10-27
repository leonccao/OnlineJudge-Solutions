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

class Solution {
    
    final static int CNT = 26;
    
    public List<Integer> findAnagrams(String s, String p) {
        int[] cp = new int[CNT];
        int[] cs = new int[CNT];
        int bits = 0, tail = 0;
        for (char ch : p.toCharArray()) 
            if (cp[ch - 'a'] ++ == 0) bits ++;
        
        List<Integer> ans = new ArrayList<Integer>(); 
        for (int head = 0; head < s.length(); head ++) {
            
            int tmp = s.charAt(head) - 'a';
            if (++ cs[tmp] == cp[tmp]) bits --;
            
            tmp = s.charAt(tail) - 'a';
            while (tail < s.length() && cs[tmp] > cp[tmp]) {
                cs[tmp] --;
                if (++ tail < s.length())
                    tmp = s.charAt(tail) - 'a';
            }
            
            if (bits == 0 && head - tail + 1 == p.length()) {
                ans.add(tail);
            }
        }
        return ans;
    }
}

// new
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[26];
        int count = 0;
        for (char ch : p.toCharArray())
            if (++ cnt[ch - 'a'] == 1)
                count ++;
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            if (-- cnt[ch - 'a'] == 0) count --;
            if (i - p.length() >= 0)
                if (++ cnt[s.charAt(i - p.length()) - 'a'] == 1)
                    count ++;
            if (count == 0) ans.add(i - p.length() + 1);
        }
        return ans;
    }
}