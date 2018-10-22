class Trie {
    
    private class TrieNode {
        private boolean ends = false;
        private TrieNode[] children = new TrieNode[26];
        
        public TrieNode() {}
        
        public TrieNode get(char val) {
            return children[val - 'a'];
        }
        
        public void add(char val, TrieNode child) {
            children[val - 'a'] = child;
        }
        
        public void setEnd() {
            ends = true;
        }
        
        public boolean getEnd() {
            return ends;
        }
    }

    private TrieNode root = new TrieNode();
    
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i ++) {
            char ch = word.charAt(i);
            if ((cur = cur.get(ch)) == null)
                return false;
        }
        if (!cur.getEnd()) return false;
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            char ch = prefix.charAt(i);
            if ((cur = cur.get(ch)) == null)
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */