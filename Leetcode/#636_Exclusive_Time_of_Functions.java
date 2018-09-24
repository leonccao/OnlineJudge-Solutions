/*
### Corner cases
1. No stop command to some task in the stack

### Solution
1. Stack
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs
1. Typo

### Test cases

*/
class Solution {
    class Process {
        int id, last;
        Process(int id, int last) {
            this.id = id;
            this.last = last;
        }
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] ans = new int[n];
        Stack<Process> stack = new Stack<Process>();
        for (String log : logs) {
            String[] tmp = log.split(":");
            int id = Integer.parseInt(tmp[0]);
            boolean status = tmp[1].equals("start") ? true : false;
            int time = Integer.parseInt(tmp[2]);
            
            if (status) {
                if (!stack.isEmpty()) {
                    Process cur = stack.peek();
                    ans[cur.id] += time - cur.last;
                }
                stack.push(new Process(id, time));
            } else {
                Process cur = stack.pop();
                ans[cur.id] += time - cur.last + 1;
                if (!stack.isEmpty()) {
                    stack.peek().last = time + 1;
                }
            }
        }
        
        
        
        return ans;
    }
}