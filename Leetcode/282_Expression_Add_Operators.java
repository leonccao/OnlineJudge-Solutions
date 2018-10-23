class Solution {
    final static char[] OP = {'+', '-', '*'};
    
    public int rank(char c) {
        switch (c) {
            case '+': return 1;
            case '-': return 1;
            case '*': return 2;
        }
        return -1;
    }
    
    public long calc(List<Object> postfix) {
        Stack<Long> operands = new Stack<Long>();
        for (Object obj : postfix)
            if (obj instanceof Character) {
                long b = operands.pop();
                long a = operands.pop();
                char c = (char)obj;
                switch (c) {
                    case '+': a += b; break;
                    case '-': a -= b; break;
                    case '*': a *= b; break;
                }
                operands.push(a);
            } else {
                operands.push((long) obj);
            }
        return operands.pop();
    }
    
    public String mix(List<Character> optRec, List<Long> operands) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < optRec.size(); i ++) {
            sb.append(operands.get(i));
            sb.append(optRec.get(i));
        }
        sb.append(operands.get(operands.size() - 1));
        return sb.toString();
    }
    
    public void creOperators(int cur, Stack<Character> tmpStack, List<Object> postfix, List<Character> optRec, List<Long> operands, List<String> ans, int target) {
        if (cur == operands.size() - 1) {
            postfix.add(operands.get(cur));
            while (!tmpStack.isEmpty())
                postfix.add(tmpStack.pop());
            if (calc(postfix) == target)
                ans.add(mix(optRec, operands));
            return;
        }
        
        
        for (char op : OP) {             
            optRec.add(op);
            Stack<Character> ts = (Stack<Character>)tmpStack.clone();
            List<Object> pf = new LinkedList<Object>();
            pf.addAll(postfix);
            pf.add(operands.get(cur));
            while (!ts.isEmpty() && rank(ts.peek()) >= rank(op))
                pf.add(ts.pop());
            ts.push(op);
            creOperators(cur + 1, ts, pf, optRec, operands, ans, target);
            optRec.remove(optRec.size() - 1);
        }
    }
    
    public void cutNums(int cur, long buf, String num, List<Long> operands, List<String> ans, int target) {
        if (cur == num.length()) {
            operands.add(buf);
            Stack<Character> tmpStack = new Stack<Character>();
            List<Object> postfix = new LinkedList<Object>();
            List<Character> optRec = new LinkedList<Character>();
            creOperators(0, tmpStack, postfix, optRec, operands, ans, target);
            operands.remove(operands.size() - 1);
            return;
        }
        
        int digit = num.charAt(cur) - '0';
        
        if (cur > 0 && buf != 0)
            cutNums(cur + 1, buf * 10 + digit, num, operands, ans, target);
        
        if (cur > 0) operands.add(buf);
        cutNums(cur + 1, digit, num, operands, ans, target);
        if (cur > 0) operands.remove(operands.size() - 1);
    }
    
    public List<String> addOperators(String num, int target) {
        List<Long> operands = new LinkedList<Long>();
        List<String> ans = new ArrayList<String>();
        cutNums(0, (long)0, num, operands, ans, target);
        return ans;
    }
}


class Solution {
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0)
            return Collections.emptyList();
        List<String> ans = new ArrayList<String>();
        search(0, 0, target, 0, "", num, ans);
        return ans;
    }
    
    private void search(int index, long sum, int target, long last, String prefix, String dict, List<String> ans) {
        if (index == dict.length()) {
            if (sum == target) ans.add(prefix);
            return;
        }
        
        long cur = 0;
        for (int i = index; i < dict.length(); i ++) {
            cur = cur * 10 + dict.charAt(i) - '0';
            if (index == 0)
                search(i + 1, cur, target, cur, "" + cur, dict, ans);
            else {
                search(i + 1, sum + cur, target,  cur, prefix + "+" + cur, dict, ans);
                search(i + 1, sum - cur, target, -cur, prefix + "-" + cur, dict, ans);
                search(i + 1, sum - last + last * cur, target, last * cur, prefix + "*" + cur, dict, ans);
            }
            if (cur == 0) break;
        }
    }
}

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<String>();
        search(0, 0, 0, target, new StringBuilder(), num, ans);
        return ans;
    }
    
    private void search(int index, long last, long sum, int target, StringBuilder prefix, String s, List<String> ans) {
        if (index == s.length()) {
            if (sum == target)
                ans.add(prefix.toString());
            return;
        }
        
        int len = prefix.length();
        long num = 0;
        for (int i = index; i < s.length(); i ++) {
            num = num * 10 + s.charAt(i) - '0';
            if (index == 0) {
                search(i + 1, num, num, target, prefix.append(num), s, ans);
                prefix.setLength(len);
            } else {
                prefix.append('+'); prefix.append(num);
                search(i + 1,  num, sum + num, target, prefix, s, ans);
                prefix.setLength(len);
                prefix.append('-'); prefix.append(num);
                search(i + 1, -num, sum - num, target, prefix, s, ans);
                prefix.setLength(len);
                prefix.append('*'); prefix.append(num);
                search(i + 1, last * num, sum - last + last * num, target, prefix, s, ans);
                prefix.setLength(len);
            }
            if (num == 0) break;
        }
    }
}