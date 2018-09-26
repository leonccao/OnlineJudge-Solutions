class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i ++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        int left = t.length(), len = 0;
        int result = Integer.MAX_VALUE, pos = -1;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            queue.offer(ch);
            len ++;
            if (visited.containsKey(ch))
                visited.put(ch, visited.get(ch) + 1);
            else if (map.containsKey(ch))
                visited.put(ch, 1);
            if (visited.containsKey(ch) && map.get(ch) >= visited.get(ch))
                left --;
            
            while (!queue.isEmpty() && (
                !map.containsKey(queue.peek()) || 
                visited.get(queue.peek()) > map.get(queue.peek()))) {
                
                if (visited.containsKey(queue.peek()))
                    visited.put(queue.peek(), visited.get(queue.peek()) - 1);
                queue.poll();
                len --;
            }
            if (left == 0 && len < result) {
                result = len;
                pos = i;
            }
        }
        
        if (pos == -1) return "";
        return s.substring(pos - result + 1, pos + 1);
    }
}

class Solution {
    
    final static int CNT = 128;
    
    public String minWindow(String s, String t) {
        if (t.length() == 0 || t.equals(null))
            return "";
        
        int ctbits = 0, j = 0, pos = -1, len = Integer.MAX_VALUE;
        int[] ct = new int[CNT];
        int[] cs = new int[CNT];
        for (char ch : t.toCharArray())
            if (ct[ch] ++ == 0) ++ ctbits;
        
        
        for (int i = 0; i < s.length(); i ++) {
            if (++ cs[s.charAt(i)] == ct[s.charAt(i)]) -- ctbits;
            while (j < s.length() && cs[s.charAt(j)] > ct[s.charAt(j)]) 
                -- cs[s.charAt(j ++)];
            
            if (ctbits == 0 && i - j + 1 < len) {
                len = i - j + 1;
                pos = j;
            }
        }
        
        return pos == -1 ? "" : s.substring(pos, pos + len); 
    }
}