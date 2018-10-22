class Solution {
    public String simplifyPath(String path) {
        String[] list = path.split("()/+()");
        Stack<String> stack = new Stack<String>();
        for (String s : list) {
            if (s.equals("") || s.length() == 0)
                continue;
            if (s.equals(".")) continue;
            if (s.equals("..")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else stack.push(s);
        }
        if (stack.isEmpty()) return "/";
        String result = "";
        while (!stack.isEmpty())
            result = "/" + stack.pop() + result;
        return result;
    }
}