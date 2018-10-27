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

class WordDictionary {
    
    class TrieNode {
        TrieNode[] children;
        String finish = "";
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode tmp = root;
        for (char ch : word.toCharArray()) {
            if (tmp.children[ch - 'a'] == null)
                tmp.children[ch - 'a'] = new TrieNode();
            tmp = tmp.children[ch - 'a'];
        }
        tmp.finish = word;
    }
    
    private boolean searchTrie(TrieNode root, String word, int index) {
        if (index == word.length())
            return root.finish.length() != 0;
        
        char ch = word.charAt(index);
        if (ch != '.') {
            if (root.children[ch - 'a'] == null)
                return false;
            return searchTrie(root.children[ch - 'a'], word, index + 1);
        } else {
            for (int i = 0; i < 26; i ++)
                if (root.children[i] != null)
                    if (searchTrie(root.children[i], word, index + 1))
                        return true;
        }
        return false;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchTrie(root, word, 0);
    }
}

// follow up speed up search

class WordDictionary {
    
    class TrieNode {
        TrieNode[] children;
        String finish = "";
        TrieNode() {
            children = new TrieNode[27];
        }
    }
    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    private void insertTrie(TrieNode root, String word, int index) {
        if (index == word.length()) {
            root.finish = word;
            return;
        }
        char ch = word.charAt(index);
        if (root.children[ch - 'a'] == null)
            root.children[ch - 'a'] = new TrieNode();
        insertTrie(root.children[ch - 'a'], word, index + 1);
        if (root.children[26] == null)
            root.children[26] = new TrieNode();
        insertTrie(root.children[26], word, index + 1);
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        insertTrie(root, word, 0);
    }
    
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int tmp = ch == '.' ? 26 : ch - 'a';
            if (cur.children[tmp] == null)
                return false;
            cur = cur.children[tmp];
        }
        return cur.finish.length() != 0;
    }
}

// new 
class WordDictionary {
    
    class TrieNode {
        boolean finished;
        TrieNode[] children;
        TrieNode() {
            finished = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null)
                cur.children[ch - 'a'] = new TrieNode();
            cur = cur.children[ch - 'a'];
        }
        cur.finished = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }
    
    private boolean searchHelper(TrieNode root, int index, String word) {
        if (index == word.length()) return root.finished;
        char ch = word.charAt(index);
        if (ch != '.') {
            if (root.children[ch - 'a'] == null) return false;
            return searchHelper(root.children[ch - 'a'], index + 1, word);
        } else {
            for (int i = 0; i < 26; i ++)
                if (root.children[i] != null)
                    if (searchHelper(root.children[i], index + 1, word))
                        return true;
            return false;
        }
    }
}