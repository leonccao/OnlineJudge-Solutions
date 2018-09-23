/*
### Corner cases:
1. Input S maybe empty
2. T may have duplicate characters

### Solution
1. Toposort
2. 

### Bugs

### Test cases

*/
class Solution {
    public String customSortString(String S, String T) {
        // calculate degree for each character
        int[] deg = new int[26];
        for (int i = 0; i < S.length(); i ++) {
            int tmp = S.charAt(i) - 'a';
            deg[tmp] = i;
        }
        // calculate count for each character
        int[] cnt = new int[26];
        for (char ch : T.toCharArray()) {
            ++ cnt[ch - 'a'];
        }
        
        StringBuilder ans = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < 26; i ++) {
            if (cnt[i] == 0) continue;
            if (deg[i]  > 0) continue;
            queue.add(i);
            for (int j = 0; j < cnt[i]; j ++)
                ans.append((char)('a' + i));
            cnt[i] = 0;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int pos = S.indexOf("" + (char)('a' + cur));
            if (pos == -1) continue;
            
            for (int i = 0; i < 26; i ++) {
                if (cnt[i] == 0) continue;
                int posb = S.indexOf("" + (char)('a' + i));
                if (pos < posb) {
                    if (-- deg[i] == 0) {
                        queue.add(i);
                        for (int j = 0; j < cnt[i]; j ++)
                            ans.append((char)('a' + i));
                        cnt[i] = 0;
                    }
                }
            }
        }
        
        return ans.toString();
    }
}