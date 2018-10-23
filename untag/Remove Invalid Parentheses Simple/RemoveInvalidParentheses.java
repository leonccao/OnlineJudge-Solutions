class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                sb.append(ch);
                cnt ++;
            } else if (ch == ')') {
                if (cnt > 0) {
                    cnt --;
                    sb.append(ch);
                }
            } else sb.append(ch);
        }
        
        s = sb.reverse().toString();
        sb = new StringBuilder();
        cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                sb.append(ch);
                cnt ++;
            } else if (ch == '(') {
                if (cnt > 0) {
                    cnt --;
                    sb.append(ch);
                }
            } else sb.append(ch);
        }
        List<String> ans = new ArrayList<String>();
        ans.add(sb.reverse().toString());
        return ans;
    }
}