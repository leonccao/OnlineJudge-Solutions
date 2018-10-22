class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int curRm = 0;
        for (char ch : num.toCharArray()) {
            while (!deque.isEmpty() && deque.peekLast() > ch && curRm < k) {
                deque.pollLast();
                curRm ++;
            }
            deque.addLast(ch);
        }
        
        while (!deque.isEmpty() && deque.peekLast() > '0' && curRm < k) {
            deque.pollLast();
            curRm ++;
        }
        if (deque.isEmpty()) deque.addLast('0');
        
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty())
            ans.append(deque.pollFirst());
        while (ans.length() > 1 && ans.charAt(0) == '0')
            ans.deleteCharAt(0);
        return ans.toString();
    }
}