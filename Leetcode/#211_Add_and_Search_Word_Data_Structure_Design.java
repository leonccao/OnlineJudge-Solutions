class WordDictionary {
    private class Trie {
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
        public Trie() {}

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
        public boolean search(String word, int start, TrieNode cur) {
            if (start == word.length()) {
                if (cur.getEnd()) return true;
                return false;
            }
            char ch = word.charAt(start);
            if (ch != '.') {
                if (cur.get(ch) == null)
                    return false;
                return this.search(word, start + 1, cur.get(ch));
            }
            for (ch = 'a'; ch <= 'z'; ch ++)
                if (cur.get(ch) != null)
                    if (this.search(word, start + 1, cur.get(ch)))
                        return true;
            return false;
        }  
        
        public boolean search(String word, int start) {
            return this.search(word, start, this.root);
        }  
    } 
    
    private Trie trie;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */