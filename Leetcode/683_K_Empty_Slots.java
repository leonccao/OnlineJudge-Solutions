class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] bloom = new int[flowers.length];
        for (int i = 0; i < flowers.length; i ++)
            bloom[flowers[i] - 1] = i;
        
        int ans = Integer.MAX_VALUE;
        if (k == 0) {
            for (int i = 0; i < flowers.length - 1; i ++)
                ans = Math.min(ans, Math.max(bloom[i], bloom[i + 1]) + 1);
            if (ans < Integer.MAX_VALUE) return ans;
            return -1;
        }
        
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < bloom.length; i ++) {
            while (!deque.isEmpty() && i - deque.peekFirst() > k) 
                deque.pollFirst();
            
            if (i > k) {
                int tmp = bloom[deque.peekFirst()];
                if (tmp > bloom[i] && tmp > bloom[i - k - 1])
                    ans = Math.min(ans, Math.max(bloom[i], bloom[i - k - 1]) + 1);
            }
            while (!deque.isEmpty() && bloom[deque.peekLast()] >= bloom[i])
                deque.pollLast();
            deque.addLast(i);
        }
        if (ans < Integer.MAX_VALUE) return ans;
        return -1;
    }
}