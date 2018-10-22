/*
class Solution {
    class Node {
        public String word;
        public int dist;
        public Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }
    
    public boolean match(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        for (int i = 0; i < s1.length(); i ++) {
            if (s1.charAt(i) == '*') continue;
            if (s2.charAt(i) == '*') continue;
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }
        
    public int minDistance(String word1, String word2) {
        Queue<Node> q = new LinkedList<Node>();
        HashSet<String> hash = new HashSet<String>();
        q.offer(new Node(word1, 0));
        hash.add(word1);
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (match(now.word, word2))
                return now.dist;
            
            // replace
            if (now.word.length() == word2.length())
            for (int i = 0; i < now.word.length(); i ++) {
                StringBuilder sb = new StringBuilder(now.word);
                sb.replace(i, i + 1, "*");
                String s = sb.toString();
                if (q.contains(s)) continue;
                q.offer(new Node(s, now.dist + 1));
                hash.add(s);
            }
            
            // insert
            if (now.word.length() < word2.length())
            for (int i = 0; i <= now.word.length(); i ++) {
                StringBuilder sb = new StringBuilder(now.word);
                sb.insert(i, '*');
                String s = sb.toString();
                if (q.contains(s)) continue;
                q.offer(new Node(s, now.dist + 1));
                hash.add(s);
            }
            
            // delete
            if (now.word.length() >= word2.length())
            for (int i = 0; i < now.word.length(); i ++) {
                StringBuilder sb = new StringBuilder(now.word);
                sb.deleteCharAt(i);
                String s = sb.toString();
                if (q.contains(s)) continue;
                q.offer(new Node(s, now.dist + 1));
                hash.add(s);
            }
            
        }
        
        return 0;
    }
}
*/
class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals("") || word1.length() == 0)
            return word2.length();
        if (word2.equals("") || word2.length() == 0)
            return word1.length();
        
        int[][] f = new int[word1.length()][word2.length()];
        f[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
        for (int i = 1; i < word2.length(); i ++) {
            f[0][i] = f[0][i - 1] + 1;
            if (word1.charAt(0) == word2.charAt(i))
                f[0][i] = Math.min(f[0][i], i);
        }
        for (int i = 1; i < word1.length(); i ++) {
            f[i][0] = f[i - 1][0] + 1;
            if (word1.charAt(i) == word2.charAt(0))
                f[i][0] = Math.min(f[i][0], i);
        }
        for (int i = 1; i < word1.length(); i ++)
            for (int j = 1; j < word2.length(); j ++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + 1;
                f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                if (word1.charAt(i) == word2.charAt(j))
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                // System.out.println(i + " " + j + " " + f[i][j]);
            }
        return f[word1.length() - 1][word2.length() - 1];
    }
}