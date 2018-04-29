class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int last = 0, len = 0;
        for (int i = 0; i < ages.length; i ++) {
            while (!queue.isEmpty() && 
                   (queue.peek() <= ages[i] / 2 + 7))
                   queue.poll();
                // System.out.println(queue.size());
            ans += queue.size();
            queue.offer(ages[i]);
            
            if (last == ages[i]) {
                if (last > last / 2 + 7)
                    ans += len;
                len ++;
            } else {
                last = ages[i];
                len = 1;
            }
        }
        return ans;
    }
}