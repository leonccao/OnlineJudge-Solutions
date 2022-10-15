class Solution {
    public String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
            cnt[ch - 'a']--;
            while (!stack.isEmpty() && isSmallestChar(stack.peek(), cnt)) {
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
    
    private boolean isSmallestChar(char ch, int[] cnt) {
        int temp = ch - 'a';
        for (int i = 0; i < temp; i++) {
            if (cnt[i] > 0) {
                return false;
            }
        }
        return true;
    }
}