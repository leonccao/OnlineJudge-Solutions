class Solution {
    public int lengthLongestPath(String input) {
        String[] str = input.replaceAll("\n", "@n@").replaceAll("\t", "t@").replaceAll("    ", "t@").split("@");
        Stack<String> stack = new Stack<String>();
        
        int ans = 0;
        int len = 0, depth = 0, t = 0;
        boolean n = false;
        for (String s : str) {
            if (s.equals("n")) {
                t = 0;
            } else if (s.equals("t")) {
                t ++;
            } else {
                if (t == 0 && s.indexOf('.') < 0) {
                    stack.clear();
                    stack.push(s);
                    len = s.length();
                    depth = 1;
                    continue;
                }
                while (depth > t) {
                    len -= stack.pop().length() + 1;
                    depth --;
                }
                StringBuilder sb = new StringBuilder();
                while (t > depth) {
                    sb.append("    ");
                    t --;
                }
                s = sb.append(s).toString();
                stack.push(s);
                len += depth > 0 ? s.length() + 1 : s.length();
                depth ++;
                if (s.indexOf('.') > -1)
                    ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}