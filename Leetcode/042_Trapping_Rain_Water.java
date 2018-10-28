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

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int prev = stack.pop();
                if (!stack.isEmpty()) {
                    int tmp = Math.min(height[i] - height[prev], 
                                        height[stack.peek()] - height[prev]);
                    ans += (i - stack.peek() - 1) * tmp;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > leftMax)
                    leftMax = height[l];
                else ans += leftMax - height[l];
                l ++;
            } else {
                if (height[r] > rightMax)
                    rightMax = height[r];
                else ans += rightMax - height[r];
                r --;
            }
        }
        return ans;
    }
}

// new stack
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int cur = height[stack.pop()];
                if (!stack.isEmpty())
                    ans += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - cur);
            }
            stack.push(i);
        }
        return ans;
    }
}

// new two scan
class Solution {
    public int trap(int[] height) {
        int[] water = new int[height.length];
        int bar = 0, ans = 0;
        for (int i = 0; i < height.length; i ++) {
            bar = Math.max(bar, height[i]);
            water[i] = bar;
        }
        bar = 0;
        for (int i = height.length - 1; i >= 0; i --) {
            bar = Math.max(bar, height[i]);
            water[i] = Math.min(water[i], bar);
            ans += water[i] - height[i];
        }
        return ans;
    }
}

// one scan two pointer
class Solution {
    public int trap(int[] height) {
        int ans = 0, l = 0, r = height.length - 1;
        int barL = 0, barR = 0;
        while (l <= r) {
            barL = Math.max(barL, height[l]);
            barR = Math.max(barR, height[r]);
            if (barL < barR) ans += barL - height[l ++];
            else ans += barR - height[r --];
        }
        return ans;
    }
}