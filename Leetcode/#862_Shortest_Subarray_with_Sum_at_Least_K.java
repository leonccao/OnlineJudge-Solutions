class Solution {
    private class Sum {
        private int val;
        private int index;
        public Sum(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public int shortestSubarray(int[] A, int K) {
        int sum = 0;
        Stack<Sum> stack = new Stack<Sum>();
        stack.push(new Sum(sum, -1));
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i ++) {
            sum += A[i];
            
            int l = 0, r = stack.size();
            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (sum - stack.get(mid).val >= K)
                    l = mid;
                else r = mid;
            }
            if (sum - stack.get(l).val >= K)
                ans = Math.min(ans, i - stack.get(l).index);
            
            while (!stack.isEmpty() && sum < stack.peek().val)
                stack.pop();
            stack.push(new Sum(sum, i));
        }
        
        if (ans < Integer.MAX_VALUE) return ans;
        return -1;
    }
}