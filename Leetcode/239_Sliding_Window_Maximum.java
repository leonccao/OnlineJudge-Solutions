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

/*
Bugs
1. Output array starts from index k - 1
2. index should be i - k + 1 other tha k - 1
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i ++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.addLast(i);
            if (i - deque.peekFirst() == k) deque.pollFirst();
            if (i >= k - 1)
                ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}

// Sliding windows start with 0 and end with 0
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < nums.length + k - 1; i ++) {
            if (i < nums.length) {
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                    deque.pollLast();
                deque.addLast(i);
            }
            while (!deque.isEmpty() && i - deque.peekFirst() >= k)
                deque.pollFirst();
            ans.add(nums[deque.peekFirst()]);
        }
        
        int[] rtn = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++)
            rtn[i] = ans.get(i);
        return rtn;
    }
}