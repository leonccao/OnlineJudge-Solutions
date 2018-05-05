class Solution {
    class Num {
        int val;
        int index;
        Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 1) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        System.out.println("not empty");
        Deque<Num> deque = new LinkedList<Num>();
        for (int i = 0; i < nums.length; i ++) {
            while (!deque.isEmpty() && deque.peekLast().val <= nums[i])
                deque.pollLast();
            deque.addLast(new Num(nums[i], i));
            if (!deque.isEmpty() && deque.peekFirst().index <= i - k)
                deque.pollFirst();
            if (i >= k - 1)
                ans[i - k + 1] = deque.peekFirst().val;
        }
        return ans;
    }
}