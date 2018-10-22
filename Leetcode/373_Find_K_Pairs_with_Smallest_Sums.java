class Solution {
    private class Pair {
        int val, x, y;
        public Pair(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new LinkedList<int[]>();
        if (nums1.length == 0 || nums2.length == 0)
            return ans;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair> (
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b) {
                    return a.val - b.val;
                }    
            }
        );
        for (int i = 0; i < nums1.length; i ++)
            pq.add(new Pair(nums1[i] + nums2[0], i, 0));
        while (k -- > 0 && !pq.isEmpty()) {
            Pair tmpPair = pq.poll();
            int[] tmpArr = new int[2];
            tmpArr[0] = nums1[tmpPair.x];
            tmpArr[1] = nums2[tmpPair.y];
            ans.add(tmpArr);
            if (++ tmpPair.y < nums2.length) 
                pq.add(new Pair(nums1[tmpPair.x] + nums2[tmpPair.y], tmpPair.x, tmpPair.y));
        }
        return ans;
    }
}