class Solution {
    public int totalSteps(int[] nums) {
        int lastPos = 0, result = 0;
        for (int pivot = 1; pivot <= nums.length; pivot++) {
            if (pivot < nums.length && nums[pivot] < nums[lastPos]) {
                continue;
            }
            
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = pivot - 1; i > lastPos; i--) {
                while (stack.size() > 0 && nums[stack.peek()] < nums[i]) {
                    stack.pop();
                }
                stack.push(i);
                result = Math.max(result, stack.size());
            }
            lastPos = pivot;
        }
        return result;
    }
}