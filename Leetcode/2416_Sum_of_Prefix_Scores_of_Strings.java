class Solution {
    
    private class TrieNode {
        int count;
        TrieNode[] nodes;
        TrieNode() {
            count = 0;
            nodes = new TrieNode[26];
        }
    }
    
    void build(TrieNode node, String word, int index) {
        if (index >= word.length()) {
            return;
        }
        char ch = word.charAt(index);
        int pos = ch - 'a';
        if (node.nodes[pos] == null) {
            node.nodes[pos] = new TrieNode();
        }
        node.nodes[pos].count++;
        build(node.nodes[pos], word, index + 1);
    }
    
    int search(TrieNode node, String word, int index) {
        if (index >= word.length()) {
            return 0;
        }
        char ch = word.charAt(index);
        int pos = ch - 'a';
        return node.nodes[pos].count + search(node.nodes[pos], word, index + 1);
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            build(root, word, 0);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            ans[i] = search(root, word, 0);
        }
        return ans;
    }
}