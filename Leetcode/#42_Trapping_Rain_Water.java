class Solution {
    class Bar {
        int h, p;
        Bar(int h, int p) {
            this.h = h;
            this.p = p;
        }
    }
    
    public int trap(int[] height) {
        int ans = 0;
        Stack<Bar> stack = new Stack<Bar>();
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[i] >= stack.peek().h) {
                Bar tmp = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i] - tmp.h, stack.peek().h - tmp.h);
                    ans += h * (i - stack.peek().p - 1);
                }
            }
            stack.push(new Bar(height[i], i));
        }
        return ans;
    }
}