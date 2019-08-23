class AutocompleteSystem {
    
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public Map<String, Integer> histories;
        
        public TrieNode() {
            children = new HashMap<>();
            histories = new HashMap<>();
        }
    }
    
    private class HeapNode {
        public String sentence;
        public int time;
        
        public HeapNode(String sentence, int time) {
            this.sentence = sentence;
            this.time = time;
        }
    }
    
    private TrieNode root, cur;
    private StringBuilder prefixSB;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        for (int i = 0; i < sentences.length; i ++) {
            insert(root, sentences[i], times[i]);
        }
        
        prefixSB = new StringBuilder();
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            String prefix = prefixSB.toString();
            prefixSB = new StringBuilder();
            insert(root, prefix, 1);
            cur = root;
            return Collections.emptyList();
        } else {
            prefixSB.append(c);
            if (cur != null) {
                cur = cur.children.getOrDefault(c, null);
            }
            if (cur == null) {
                return Collections.emptyList();
            }
            return findTopThree(cur.histories);
        }
    }
        
    private void insert(TrieNode root, String sentence, int time) {
        TrieNode cur = root;
        for (char ch : sentence.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
            cur.histories.put(sentence, cur.histories.getOrDefault(sentence, 0) + time);
        }
    }
    
    private List<String> findTopThree(Map<String, Integer> histories) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<>((a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;
            }
            return b.sentence.compareTo(a.sentence);
        });
        
        for (String sentence : histories.keySet()) {
            int time = histories.get(sentence);
            if (pq.size() >= 3) {
                HeapNode head = pq.peek();
                if (time > head.time || (time == head.time && sentence.compareTo(head.sentence) < 0)) {
                    pq.poll();
                    pq.add(new HeapNode(sentence, time));
                    continue;
                }
                continue;
            }
            pq.add(new HeapNode(sentence, time));
        }
        
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().sentence);
        }
        Collections.reverse(ans);
        return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */