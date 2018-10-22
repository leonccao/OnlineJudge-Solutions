class Solution {
    public String decodeString(String s) {
        
        Stack<Object> stack = new Stack<Object>();
        
        int curNum = 0;
        StringBuilder curStr = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                curNum = curNum * 10 + ch - '0';
                if (curStr.length() > 0) {
                    stack.push(curStr);
                    curStr = new StringBuilder();
                }
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                curStr.append(ch);
            } else if (ch == '[') {
                stack.push(curNum);
                curNum = 0;
            } else if (ch == ']') {
                while (!(stack.peek() instanceof Integer))
                    curStr.insert(0, (StringBuilder)stack.pop());
                int k = (int)stack.pop();
                StringBuilder tmp = new StringBuilder(curStr);
                for (int i = 1; i < k; i ++) 
                    tmp.append(curStr);
                stack.push(tmp);
                curStr = new StringBuilder();
            }
        }
        if (curStr.length() != 0)
            stack.push(curStr);
        
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.insert(0, (StringBuilder)stack.pop());
        return ans.toString();
    }
}