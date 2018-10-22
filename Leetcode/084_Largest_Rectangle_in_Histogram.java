class Solution {
    class Rect {
        public int h;
        public int p;
        public Rect(int h, int p) {
            this.h = h;
            this.p = p;
        }
    }
    
    public int largestRectangleArea(int[] heights) {
        int[] hs = Arrays.copyOf(heights, heights.length + 1);
        hs[hs.length - 1] = Integer.MIN_VALUE;
        Stack<Rect> stack = new Stack<Rect>();
        int result = 0;
        for (int i = 0; i < hs.length; i ++) {
            int last = i;
            while (!stack.isEmpty() && stack.peek().h > hs[i]) {
                int area = (i - stack.peek().p) * stack.peek().h;
                result = Math.max(result, area);
                last = stack.peek().p;
                stack.pop();
            }
            stack.push(new Rect(hs[i], last));
        }
        return result;
    }
}