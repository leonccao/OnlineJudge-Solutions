class StreamChecker {
    
    public class TrieNode {
        private boolean ends = false;
        private TrieNode[] children = new TrieNode[26];
        
        public TrieNode() {}
        
        public TrieNode get(char val) {
            return children[val - 'a'];
        }
        
        public void add(char val, TrieNode child) {
            children[val - 'a'] = child;
        }
        
        public void setEnd() { ends = true;}
        
        public boolean getEnd() { return ends;}
    }

    public TrieNode root;
    public List<Character> list;
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            if (cur.get(ch) == null)
                cur.add(ch, new TrieNode());
            cur = cur.get(ch);
        }
        cur.setEnd();
    }


    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String s : words) {
            StringBuilder sb = new StringBuilder(s);
            sb = sb.reverse();
            insert(sb.toString());
        }
        list = new ArrayList<>();
    }
    
    public boolean search(TrieNode root, int pos) {
        if (pos < 0) return false;
        char ch = list.get(pos);
        TrieNode cur = root.get(ch);
        if (cur == null) return false;
        if (cur.getEnd()) return true;
        return search(cur, pos - 1);
    }
    
    public boolean query(char letter) {
        list.add(letter);
        return search(root, list.size() - 1);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */