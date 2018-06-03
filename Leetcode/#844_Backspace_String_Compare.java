class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> a = new Stack<Character>();
        for(char ch : S.toCharArray())
            if (ch == '#') {
                if (!a.isEmpty()) a.pop();
            } else a.push(ch);
        
        Stack<Character> b = new Stack<Character>();
        for(char ch : T.toCharArray())
            if (ch == '#') {
                if (!b.isEmpty()) b.pop();
            } else b.push(ch);
        
        if (a.size() != b.size()) return false;
        while (!a.isEmpty())
            if (a.pop() != b.pop())
                return false;
        return true;
    }
}