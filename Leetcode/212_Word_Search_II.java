class Solution {
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
        
        public void setEnd() { ends = true;}
        
        public boolean getEnd() { return ends;}
    }

    private TrieNode root = new TrieNode();
    
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
    
    final static int[][] move = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public void search(TrieNode root, StringBuilder sb, int x, int y, char[][] board, List<String> list) {
        if (root.getEnd()) {
            String s = sb.toString();
            if (!list.contains(s))
                list.add(s);
        }
        for (int[] mv : move) {
            int i = x + mv[0];
            int j = y + mv[1];
            if (i < 0 || i == board.length   ) continue;
            if (j < 0 || j == board[0].length) continue;
            char ch = board[i][j];
            if (ch == '@') continue;
            TrieNode next = root.get(ch);
            if (next == null) continue;
            
            board[i][j] = '@';
            search(next, sb.append(ch), i, j, board, list);
            sb.deleteCharAt(sb.length() - 1);
            board[i][j] = ch;
        }
    }
    
    public void search(int x, int y, char[][] board, List<String> list) {
        char ch = board[x][y];
        TrieNode next = root.get(ch);
        if (next == null) return;
        board[x][y] = '@';
        StringBuilder sb = new StringBuilder();
        sb.append(ch);
        search(next, sb, x, y, board, list);
        board[x][y] = ch;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words)
            insert(word);
        
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < board.length; i ++)
            for (int j = 0; j < board[0].length; j ++)
                search(i, j, board, list);
        return list;
    }
}