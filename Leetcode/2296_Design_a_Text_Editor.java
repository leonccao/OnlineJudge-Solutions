class TextEditor {
    
    class Node {
        char ch;
        Node prev, next;
        public Node(char ch) {
            this.ch = ch;
        }
    }

    Node head, tail, cur;
    
    public TextEditor() {
        head = new Node(' ');
        tail = new Node(' ');
        head.next = tail;
        tail.prev = head;
        cur = tail;
    }
    
    public void addText(String text) {
        for (char ch : text.toCharArray()) {
            insertNode(new Node(ch));
        }
    }
    
    public int deleteText(int k) {
        int count = 0;
        while (cur.prev != head && k > 0) {
            cur.prev = cur.prev.prev;
            cur.prev.next = cur;
            count++;
            k--;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while (cur.prev != head && k > 0) {
            cur = cur.prev;
            k--;
        }
        return printText();
    }
    
    public String cursorRight(int k) {
        while (cur != tail && k > 0) {
            cur = cur.next;
            k--;
        }
        return printText();
    }
    
    private void insertNode(Node node) {
        node.prev = cur.prev;
        node.next = cur;
        node.prev.next = node;
        node.next.prev = node;
    }
    
    private String printText() {
        StringBuilder sb = new StringBuilder();
        int cnt = 10;
        for (Node p = cur.prev; p != head && cnt > 0; p = p.prev) {
            sb.append(p.ch);
            cnt--;
        }
        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */