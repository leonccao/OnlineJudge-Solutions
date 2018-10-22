class Solution {
    class Rect {
        public int h;
        public int p;
        public Rect(int h, int p) {
            this.h = h;
            this.p = p;
        }
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] hs = new int[matrix[0].length + 1];
        
        int result = 0;
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = 0; j < matrix[0].length; j ++)
                if (matrix[i][j] == '0')
                    hs[j] = 0;
                else hs[j] ++;
            
            Stack<Rect> stack = new Stack<Rect>();
            for (int j = 0; j < hs.length; j ++) {
                int last = j;
                while (!stack.isEmpty() && stack.peek().h > hs[j]) {
                    int area = (j - stack.peek().p) * stack.peek().h;
                    result = Math.max(result, area);
                    last = stack.peek().p;
                    stack.pop();
                }
                stack.push(new Rect(hs[j], last));
            }
        }
        return result;
    }
}